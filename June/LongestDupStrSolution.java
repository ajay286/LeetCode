package com.serverless.June;

/*
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)
 * Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)
 * */

import java.util.HashSet;

public class LongestDupStrSolution {
	public int search(int L, int a, long modulus, int n, int[] nums) {

		long h = 0;
		for (int i = 0; i < L; ++i)
			h = (h * a + nums[i]) % modulus;
		HashSet<Long> seen = new HashSet<Long>();
		seen.add(h);

		long aL = 1;
		for (int i = 1; i <= L; ++i)
			aL = (aL * a) % modulus;

		for (int start = 1; start < n - L + 1; ++start) {

			h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
			h = (h + nums[start + L - 1]) % modulus;
			if (seen.contains(h))
				return start;
			seen.add(h);
		}
		return -1;
	}

	public String longestDupSubstring(String S) {
		int n = S.length();
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i)
			nums[i] = (int) S.charAt(i) - (int) 'a';

		int a = 26;

		long modulus = (long) Math.pow(2, 32);

		int left = 1, right = n;
		int L;
		while (left != right) {
			L = left + (right - left) / 2;
			if (search(L, a, modulus, n, nums) != -1)
				left = L + 1;
			else
				right = L;
		}

		int start = search(left - 1, a, modulus, n, nums);
		return start != -1 ? S.substring(start, start + left - 1) : "";
	}

	public static void main(String[] args) {
		LongestDupStrSolution solution = new LongestDupStrSolution();
		System.out.println(solution.longestDupSubstring("banana"));
		System.out.println(solution.longestDupSubstring("abcd"));
		System.out.println(solution.longestDupSubstring(
				"moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfaiviraqcycjmskrozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigynxbqodiyioapgxqkndujeranxgebnpgsukybyowbxhgpkwjfdywfkpufcxzzqiuglkakibbkobonunnzwbjktykebfcbobxdflnyzngheatpcvnhdwkkhnlwnjdnrmjaevqopvinnzgacjkbhvsdsvuuwwhwesgtdzuctshytyfugdqswvxisyxcxoihfgzxnidnfadphwumtgdfmhjkaryjxvfquucltmuoosamjwqqzeleaiplwcbbxjxxvgsnonoivbnmiwbnijkzgoenohqncjqnckxbhpvreasdyvffrolobxzrmrbvwkpdbfvbwwyibydhndmpvqyfmqjwosclwxhgxmwjiksjvsnwupraojuatksjfqkvvfroqxsraskbdbgtppjrnzpfzabmcczlwynwomebvrihxugvjmtrkzdwuafozjcfqacenabmmxzcueyqwvbtslhjeiopgbrbvfbnpmvlnyexopoahgmwplwxnxqzhucdieyvbgtkfmdeocamzenecqlbhqmdfrvpsqyxvkkyfrbyolzvcpcbkdprttijkzcrgciidavsmrczbollxbkytqjwbiupvsorvkorfriajdtsowenhpmdtvamkoqacwwlkqfdzorjtepwlemunyrghwlvjgaxbzawmikfhtaniwviqiaeinbsqidetfsdbgsydkxgwoqyztaqmyeefaihmgrbxzyheoegawthcsyyrpyvnhysynoaikwtvmwathsomddhltxpeuxettpbeftmmyrqclnzwljlpxazrzzdosemwmthcvgwtxtinffopqxbufjwsvhqamxpydcnpekqhsovvqugqhbgweaiheeicmkdtxltkalexbeftuxvwnxmqqjeyourvbdfikqnzdipmmmiltjapovlhkpunxljeutwhenrxyfeufmzipqvergdkwptkilwzdxlydxbjoxjzxwcfmznfqgoaemrrxuwpfkftwejubxkgjlizljoynvidqwxnvhngqakmmehtvykbjwrrrjvwnrteeoxmtygiiygynedvfzwkvmffghuduspyyrnftyvsvjstfohwwyxhmlfmwguxxzgwdzwlnnltpjvnzswhmbzgdwzhvbgkiddhirgljbflgvyksxgnsvztcywpvutqryzdeerlildbzmtsgnebvsjetdnfgikrbsktbrdamfccvcptfaaklmcaqmglneebpdxkvcwwpndrjqnpqgbgihsfeotgggkdbvcdwfjanvafvxsvvhzyncwlmqqsmledzfnxxfyvcmhtjreykqlrfiqlsqzraqgtmocijejneeezqxbtomkwugapwesrinfiaxwxradnuvbyssqkznwwpsbgatlsxfhpcidfgzrc"));

	}

}
