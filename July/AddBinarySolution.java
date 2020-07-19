public class AddBinarySolution {

	public String padLeftZeros(String inputString, int length) {
		if (inputString.length() >= length) {
			return inputString;
		}
		StringBuilder sb = new StringBuilder();
		while (sb.length() < length - inputString.length()) {
			sb.append('0');
		}
		sb.append(inputString);

		return sb.toString();
	}

	public String addBinary(String a, String b) {
		int lengthA = a.length(), lengthB = b.length();
		char resultArray[] = new char[Math.max(lengthA, lengthB) + 1];
		if (lengthA != lengthB) {
			int minLength = Math.min(lengthA, lengthB);
			if (minLength == lengthA) {
				a = this.padLeftZeros(a, lengthB);
			} else {
				b = this.padLeftZeros(b, lengthA);
			}
		}

		char remainder = '0';
		for (int i = a.length() - 1; i >= 0; --i) {
			char charA = a.charAt(i);
			char charB = b.charAt(i);
			if (charA == charB && charA == '1' && remainder == '1') {
				resultArray[i + 1] = '1';
				remainder = '1';
			} else if (charA == charB && charA == '0') {
				resultArray[i + 1] = remainder;
				remainder = '0';
			} else if (charA == charB && charA == '1' && remainder == '0') {
				resultArray[i + 1] = '0';
				remainder = '1';
			} else if (charA != charB && remainder == '1') {
				resultArray[i + 1] = '0';
				remainder = '1';
			} else {
				resultArray[i + 1] = '1';
				remainder = '0';
			}

		}

		if (remainder == '1')
			resultArray[0] = '1';

		String result = new String(resultArray);

		return result.trim();
	}

	public static void main(String[] args) {
		AddBinarySolution solution = new AddBinarySolution();
		System.out.println(solution.addBinary("1010", "1011"));
		System.out.println(solution.addBinary("11", "1"));
		System.out.println(solution.addBinary("1", "1"));
		System.out.println(solution.addBinary("0", "1"));
		System.out.println(solution.addBinary("0", "0"));
	}

}
