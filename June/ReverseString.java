import java.util.Arrays;

/* Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 * */

public class ReverseString {

	public void reverseString(char[] s) {
		int lb = 0, ub = s.length - 1;
		char tempHolder;

		while (lb < ub) {
			tempHolder = s[lb];
			s[lb] = s[ub];
			s[ub] = tempHolder;
			lb++;
			ub--;
		}

	}

	public static void main(String[] args) {
		ReverseString reverseStr = new ReverseString();
		char[] s = "hello".toCharArray();
		System.out.println(Arrays.toString(s));
		reverseStr.reverseString(s);
		System.out.println(Arrays.toString(s));

	}

}
