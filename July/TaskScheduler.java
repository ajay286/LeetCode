class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        if (tasks.length == 0)
            return 0;

        int[] freqs = new int[26];
        for (char task: tasks) {
            ++freqs[task - 'A'];
        }

        Arrays.sort(freqs);

        int i = 25, mx = freqs[25], len = tasks.length;
        while (i >= 0 && freqs[i] == mx) --i;
        return Math.max(len, (mx - 1) * (n + 1) + 25 - i);


    }

}
