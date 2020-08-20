class GoatLatinSolution {
    public String toGoatLatin(String S) {
        Set < String > vowelSet = new HashSet < String > (Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));


        StringBuffer result = new StringBuffer();
        StringBuffer suffix = new StringBuffer();
        String[] strs = S.split(" ");
        for (String str: strs) {
            this.helperGoatLatin(suffix, result, vowelSet, str);
        }

        return result.toString().stripTrailing();
    }

    private void helperGoatLatin(StringBuffer suffix, StringBuffer result, Set < String > vowelSet, String input) {
        StringBuffer temp = new StringBuffer();
        if (vowelSet.contains(input.substring(0, 1))) {
            temp.append(input);
            temp.append("maa");
            temp.append(suffix);
            result.append(temp);
        } else {

            temp.append(input.substring(1));
            temp.append(input.substring(0, 1));
            temp.append("maa");
            temp.append(suffix);
            result.append(temp);
        }

        result.append(" ");
        suffix.append("a");

    }
}
