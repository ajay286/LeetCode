import java.util.Arrays;
import java.util.Comparator;

/*
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 * */

public class TwoCityScheduling {

	public int twoCitySchedCost(int[][] costs) {
		int result = 0;

		Comparator<int[]> comparator = (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
		Arrays.parallelSort(costs, comparator);

		int ub = costs.length / 2;
		int c1 = 0, c2 = 0, i = 0;

		while (i < costs.length) {
			if ((costs[i][0] <= costs[i][1] && c1 < ub) || c2 == ub) {
				result += costs[i++][0];
				++c1;
			} else {
				result += costs[i++][1];
				++c2;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] costs = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
		TwoCityScheduling twoCityScheduling = new TwoCityScheduling();

		System.out.println(String.format("Cost to schedule is -> %s", twoCityScheduling.twoCitySchedCost(costs)));
	}

}
