/*
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have infinite number of each kind of coin.
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * */

public class CoinChangeSolution {

	public int change(int amount, int[] coins) {

		int[][] matrix = new int[amount + 1][coins.length + 1];

		for (int i = 0; i <= coins.length; i++)
			matrix[0][i] = 1;

		for (int i = 1; i <= amount; i++)
			matrix[i][0] = 0;

		for (int amountC = 1; amountC <= amount; amountC++) {
			for (int size = 1; size <= coins.length; size++) {

				int val = coins[size - 1];
				int n = amountC / val;
				for (int i = 0; i <= n; i++) {
					int remain = amountC - i * val;
					if (remain >= 0)
						matrix[amountC][size] += matrix[remain][size - 1];
				}
			}
		}

		return matrix[amount][coins.length];

	}

	public static void main(String[] args) {
		CoinChangeSolution coinChangeSolution = new CoinChangeSolution();
		System.out.println(coinChangeSolution.change(5, new int[] { 1, 5, 2 }));
	}

}
