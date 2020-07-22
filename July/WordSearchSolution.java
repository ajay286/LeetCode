class WordSearchSolution {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, visited))
                    return true;
            }

        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {

        if (index == word.length() - 1)
            return true;

        visited[i][j] = true;


        if (i < board.length - 1 && !visited[i + 1][j] && board[i + 1][j] == word.charAt(index + 1) && dfs(board, i + 1, j, word, index + 1, visited))
            return true;

        if (j < board[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == word.charAt(index + 1) && dfs(board, i, j + 1, word, index + 1, visited))
            return true;

        if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == word.charAt(index + 1) && dfs(board, i - 1, j, word, index + 1, visited))
            return true;

        if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == word.charAt(index + 1) && dfs(board, i, j - 1, word, index + 1, visited))
            return true;



        visited[i][j] = false;
        return false;
    }
}
