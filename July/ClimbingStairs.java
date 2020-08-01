class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;

        int j = 1;
        int k = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = j + k;
            k = j;
            j = tmp;
        }

        return j;
    }
}
