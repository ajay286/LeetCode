class DetectCapital {
    public boolean detectCapitalUse(String word) {
        boolean isPrevCaps = false, isFirstCaps = false;

        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);

            if (('Z' - (int) ch) >= 0) {

                if (i == 0) {
                    isFirstCaps = true;
                    isPrevCaps = true;
                    continue;
                }

                if (!isPrevCaps) {
                    return false;
                }

            } else {
                if (isFirstCaps && isPrevCaps && i > 1)
                    return false;
                isPrevCaps = false;
            }

        }

        return true;

    }
}
