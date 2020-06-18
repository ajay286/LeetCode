/*
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: 
 * A scientist has index h if h of his/her N papers have at least h citations each, 
 * and the other N − h papers have no more than h citations each.
 * */

public class HIndexSolution {

	public int hIndex(int[] citations) {
		int lb = 0, ub = citations.length - 1;

		while (lb <= ub) {
			int mid = (lb + ub) / 2;

			if (citations[mid] == citations.length - mid)
				return citations[mid];
			else if (citations[mid] < citations.length - mid)
				lb = mid + 1;
			else
				ub = mid - 1;

		}

		return citations.length - ub - 1;
	}

	public static void main(String[] args) {

		HIndexSolution solution = new HIndexSolution();
		System.out.println(solution.hIndex(new int[] { 0, 1, 3, 5, 6 }));

	}

}
