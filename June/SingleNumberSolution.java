public class SingleNumberSolution {
	public int singleNumber(int[] nums) {
		int x1 = 0, x2 = 0, mask = 0;

		for (int i : nums) {
			x2 ^= x1 & i;
			x1 ^= i;
			mask = ~(x1 & x2);
			x2 &= mask;
			x1 &= mask;
		}

		return x1;

	}

	public static void main(String[] args) {
		SingleNumberSolution solution = new SingleNumberSolution();
		System.out.println(solution.singleNumber(new int[] { 2, 2, 3, 2 }));
		System.out.println(solution.singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
	}

}
