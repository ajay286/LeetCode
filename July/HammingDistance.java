public class HammingDistance {
	private int result = 0;

	public int hammingDistance(int x, int y) {
		int bitwiseXor = x ^ y;

		this.bin(bitwiseXor);
		return this.result;

	}

	private void bin(int n) {
		if (n > 1)
			bin(n / 2);

		if (n % 2 != 0)
			++this.result;
	}
	
	public static void main(String[] args) {
		HammingDistance distance = new HammingDistance();
		System.out.println(distance.hammingDistance(1, 4));
	}

}
