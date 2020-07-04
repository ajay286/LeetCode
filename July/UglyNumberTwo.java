public class UglyNumberTwo {

	public int nthUglyNumber(int n) {
		if (n == 0)
			return 0;
		
		int[] result = new int[n];
		int cTwo = 0, cThree = 0, cFive = 0, nextUglyNumber = 1;
		int mult2 = 2, mult3 = 3, mult5 = 5;
		
		result[0] = nextUglyNumber;

		for (int i = 1; i < n; ++i) {
			nextUglyNumber = Math.min(mult2, Math.min(mult3, mult5));
			result[i] = nextUglyNumber;

			if (nextUglyNumber == mult2) {
				cTwo++;
				mult2 = result[cTwo] * 2;
			} 
			
			if (nextUglyNumber == mult3) {
				cThree++;
				mult3 = result[cThree] * 3;
			}
			
			if(nextUglyNumber == mult5) {
				cFive++;
				mult5 = result[cFive] * 5;
			}
		}

		return nextUglyNumber;

	}

	public static void main(String[] args) {
		UglyNumberTwo solUglyNumberTwo = new UglyNumberTwo();
		System.out.println(solUglyNumberTwo.nthUglyNumber(10));
	}

}
