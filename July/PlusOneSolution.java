import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PlusOneSolution {
	public int[] plusOne(int[] digits) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int remainder = 1;
		for (int i = digits.length - 1; i >= 0; --i) {
			int digit = digits[i];
			digit = digit + remainder;
			remainder = digit / 10;
			digit = digit % 10;
			list.add(digit);
		}

		if (remainder > 0)
			list.add(remainder);

		Collections.reverse(list);

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		int[] digits = { 1, 2, 3 };
		PlusOneSolution solution = new PlusOneSolution();
		System.out.println(Arrays.toString(solution.plusOne(digits)));

	}
}
