public class DungeonGame {

	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length;
		int column = dungeon[0].length;
		int solution[][] = new int[row][column];
		for (int i = row - 1; i >= 0; --i) {
			for (int j = column - 1; j >= 0; --j) {
				if (i == row - 1 && j == column - 1) {
					solution[i][j] = dungeon[i][j] >= 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
					continue;
				}

				if (i == row - 1) {
					solution[i][j] = dungeon[i][j] - solution[i][j + 1] >= 0 ? 1
							: Math.abs(dungeon[i][j] - solution[i][j + 1]);
					continue;
				}

				if (j == column - 1) {
					solution[i][j] = dungeon[i][j] - solution[i + 1][j] >= 0 ? 1
							: Math.abs(dungeon[i][j] - solution[i + 1][j]);
					continue;
				}

			}
		}

		for (int i = row - 2; i >= 0; --i) {
			for (int j = column - 2; j >= 0; --j) {
				solution[i][j] = Math.max(Math.min(solution[i][j + 1], solution[i + 1][j]) - dungeon[i][j], 1);
			}
		}

		return solution[0][0];
	}

	public static void main(String[] args) {
		DungeonGame solGame = new DungeonGame();
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(solGame.calculateMinimumHP(dungeon));

	}

}
