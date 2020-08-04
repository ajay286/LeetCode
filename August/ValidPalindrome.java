class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toUpperCase();

        if (s.length() == 0)
            return true;

        boolean result = true;
        for (int i = 0, j = s.length() - 1; i != j & i < s.length() && j > 0; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                result = false;
                break;
            }


        }

        return result;
    }
}
