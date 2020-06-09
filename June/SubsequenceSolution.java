/*
 * Given a string s and a string t, check if s is subsequence of t.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * */

public class SubsequenceSolution {

	public boolean isSubsequence(String s, String t) {

		if (s.length() == 0) {
			return true;
		}

		if (s.length() > t.length())
			return false;

		int j = 0;
		int matched = s.length();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			for (; j < t.length();) {
				if (t.charAt(j) == ch) {
					--matched;
					++j;
					break;
				} else
					++j;
			}

			if (matched == 0)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		SubsequenceSolution solution = new SubsequenceSolution();

		System.out.println(solution.isSubsequence("abc", "ahbgdc"));
		System.out.println(solution.isSubsequence("axc", "ahbgdc"));
	}

}
