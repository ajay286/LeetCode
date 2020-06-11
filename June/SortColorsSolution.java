import java.util.Arrays;

/*
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * */

public class SortColorsSolution {
	public void sortColors(int[] nums) {

		int i = 0, lb = 0, ub = nums.length - 1;
		int placeHolder;
		while (i <= ub) {
			if (nums[i] == 2) {
				placeHolder = nums[ub];
				nums[ub] = nums[i];
				nums[i] = placeHolder;
				--ub;

			} else if (nums[i] == 1) {
				++i;
			} else {
				placeHolder = nums[lb];
				nums[lb] = nums[i];
				nums[i] = placeHolder;
				++i;
				++lb;
			}

		}

	}

	public static void main(String[] args) {

		SortColorsSolution solution = new SortColorsSolution();
		int[] colors = { 2, 0, 2, 1, 1, 0 };
		System.out.print("Before " + Arrays.toString(colors) + " After ->");
		solution.sortColors(colors);
		System.out.println(Arrays.toString(colors));

		colors = new int[] { 2, 0, 1 };
		System.out.print("Before " + Arrays.toString(colors) + " After ->");
		solution.sortColors(colors);
		System.out.println(Arrays.toString(colors));

	}
}
