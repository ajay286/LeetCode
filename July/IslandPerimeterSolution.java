public class IslandPerimeterSolution {
	public int islandPerimeter(int[][] grid) {
		int result = 0;

		int row = grid.length;
		int columns = grid[0].length;

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < columns; ++j) {
				if (grid[i][j] == 1) {

					if (j - 1 < 0 || grid[i][j - 1] == 0)
						++result;
					if (i - 1 < 0 || grid[i - 1][j] == 0)
						++result;
					if (i + 1 >= row || grid[i + 1][j] == 0)
						++result;
					if (j + 1 >= columns || grid[i][j + 1] == 0)
						++result;

				}

			}

		}
		return result;

	}

	public static void main(String[] args) {
		IslandPerimeterSolution solution = new IslandPerimeterSolution();
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(solution.islandPerimeter(grid));
	}
}
