class LongestPalindromeSolution {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] freqArray = new int[58];
        Arrays.fill(freqArray, 0);
        for (char ch: s.toCharArray()) {
            int index = (int) ch - (int)
            'A';
            ++freqArray[index];
        }

        boolean containsOdd = false;

        for (int freq: freqArray) {
            if (freq % 2 == 0) {
                result += freq;
            } else {
                result += freq - 1;
                containsOdd = true;
            }
        }

        return containsOdd ? result + 1 : result;
    }
}
