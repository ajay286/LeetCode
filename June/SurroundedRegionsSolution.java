/*
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * */

import java.util.Arrays;

public class SurroundedRegionsSolution {

	public void solve(char[][] board) {

		if (board.length == 0)
			return;

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] == 'O' && (i == 0 || j == 0 || j == board[i].length - 1 || i == board.length - 1))
					this.dfs(board, i, j);
			}
		}

		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] == 'N')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}

	}

	private void dfs(char[][] board, int i, int j) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 'O') {
			board[i][j] = 'N';
			this.dfs(board, i - 1, j);
			this.dfs(board, i + 1, j);
			this.dfs(board, i, j - 1);
			this.dfs(board, i, j + 1);
		}

	}

	public void printMatrix(char[][] board) {
		for (char[] row : board)
			System.out.println(Arrays.toString(row));

		System.out.println("============");
	}

	public static void main(String[] args) {
		SurroundedRegionsSolution solution = new SurroundedRegionsSolution();

		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		solution.printMatrix(board);
		solution.solve(board);
		solution.printMatrix(board);
	}

}
