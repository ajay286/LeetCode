import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	private List<Integer> innerLargestDivisibleSubset(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return new ArrayList<Integer>();

		for (int number : nums) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(number);
			result.add(list);

		}

		for (int i = 0; i < nums.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[i] % nums[j] == 0 && result.get(i).size() < result.get(j).size() + 1) {

					List<Integer> clonedList = new ArrayList<Integer>(result.get(j));
					clonedList.add(nums[i]);
					result.set(i, clonedList);

				}

			}
		}

		int size = 0;
		int index = -1;
		for (int i = 0; i < result.size(); ++i) {
			if (size < result.get(i).size()) {
				size = result.get(i).size();
				index = i;
			}
		}

		return result.get(index);
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.parallelSort(nums);
		return this.innerLargestDivisibleSubset(nums);
	}

	public static void main(String[] args) {
		LargestDivisibleSubset solDivisibleSubset = new LargestDivisibleSubset();
		System.out.println(solDivisibleSubset.largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));
	}
}
