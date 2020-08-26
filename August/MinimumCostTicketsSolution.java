class MinimumCostTicketsSolution {
    public int mincostTickets(int[] days, int[] costs) {
        int totalDays = days.length;
        int[] dp = new int[totalDays + 1];
        Arrays.fill(dp, costs[0] * 365);
        dp[totalDays] = 0;

        for (int i = totalDays - 1; i >= 0; --i) {
            int daySeven = i, dayThirty = i;

            while (daySeven < totalDays && days[daySeven] < days[i] + 7)
                ++daySeven;

            while (dayThirty < totalDays && days[dayThirty] < days[i] + 30)
                ++dayThirty;

            dp[i] = Math.min(costs[0] + dp[i + 1], Math.min(costs[1] + dp[daySeven], costs[2] + dp[dayThirty]));


        }

        return dp[0];

    }
}
