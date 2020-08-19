class NumbersConsecutiveDiffSolution {
    public int[] numsSameConsecDiff(int N, int K) {
        ArrayList < Integer > result = new ArrayList < Integer > ();
        if (N == 1)
            result.add(0);

        for (int i = 1; i <= 9; ++i) {
            dfs(N - 1, K, i, result);
        }

        int[] ret = new int[result.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = result.get(i).intValue();
        }

        return ret;
    }

    private void dfs(int N, int K, int cur, ArrayList < Integer > result) {
        if (N == 0) {
            result.add(cur);
            return;
        }

        int l = cur % 10;
        if (l + K < 10)
            dfs(N - 1, K, cur * 10 + l + K, result);
        if (l >= K && K != 0)
            dfs(N - 1, K, cur * 10 + l - K, result);
    }

}
