import java.util.ArrayList;
import java.util.List;

public class SubsetsSolution {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> subsets(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < (1 << n); i++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < n; j++)

				if ((i & (1 << j)) > 0)
					list.add(nums[j]);

			this.result.add(list);
		}

		return this.result;
	}

	public static void main(String[] args) {
		SubsetsSolution solution = new SubsetsSolution();
		List<List<Integer>> output = solution.subsets(new int[] { 1, 2, 3 });
		for (List<Integer> list : output)
			System.out.println(list);
	}

}
