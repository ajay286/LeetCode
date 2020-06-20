import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceSolution {

	public String getPermutation(int n, int k) {

		StringBuffer buffer = new StringBuffer();
		int factorial[] = new int[n];
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 1; i <= n; ++i)
			list.add(i);
		
		factorial[0] = 1;
		for (int i = 1; i < n; ++i) {
			factorial[i] = i * factorial[i - 1];
		}

		--k;

		for (int i = n - 1; i >= 0; --i) {
			int index = k / factorial[i];
			buffer.append(list.remove(index));
			k = k % factorial[i];
		}

		return buffer.toString();

	}

	public static void main(String[] args) {
		PermutationSequenceSolution solution = new PermutationSequenceSolution();
		System.out.println(solution.getPermutation(3, 3));
		System.out.println(solution.getPermutation(4, 9));
		System.out.println(solution.getPermutation(3, 5));
	}

}
