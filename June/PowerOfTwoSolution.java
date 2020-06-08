public class PowerOfTwoSolution {

	public boolean isPowerOfTwo(int n) {
		if (n <= 1)
			return true ? n == 1 : false;

		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}

		return true;
	}

	public static void main(String[] args) {
		PowerOfTwoSolution powerOfTwoSolution = new PowerOfTwoSolution();
		System.out.println(powerOfTwoSolution.isPowerOfTwo(218));
	}

}
