import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class ThreeSumSolution {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	private TreeSet<String> checkElement = new TreeSet<String>();

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.parallelSort(nums);

		for (int i = 0; i < nums.length - 2; ++i) {
			int a = nums[i];
			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {
				int b = nums[start];
				int c = nums[end];
				if (a + b + c == 0) {

					String str = a + "_" + b + "_" + c;
					if (!this.checkElement.contains(str)) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(a);
						list.add(b);
						list.add(c);
						result.add(list);
						this.checkElement.add(str);
					}

					start = start + 1;
					end = end - 1;
				} else if (a + b + c > 0)
					end = end - 1;
				else
					start = start + 1;

			}
		}

		return this.result;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		ThreeSumSolution solution = new ThreeSumSolution();
		List<List<Integer>> result = solution.threeSum(nums);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

}
