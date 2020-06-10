/*
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * */

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {

		if (target < nums[0])
			return 0;
		else if (target > nums[nums.length - 1])
			return nums.length;

		int lb = 0, ub = nums.length;

		while (lb < ub) {
			int mid = (lb + ub) / 2;

			if (nums[mid] > target) {
				ub = mid;
			} else if (nums[mid] < target) {
				lb = mid + 1;
			} else {
				return mid;
			}
		}

		return lb;
	}

	public static void main(String[] args) {
		SearchInsertPosition solInsertPosition = new SearchInsertPosition();
		System.out.println(solInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 1));
		System.out.println(solInsertPosition.searchInsert(new int[] { 1, 3 }, 2));
		System.out.println(solInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(solInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
		System.out.println(solInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 4));
	}
}
