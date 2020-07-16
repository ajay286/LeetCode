class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strArray = s.split(" ");
        int lb = 0, ub = strArray.length - 1;


        while (lb < ub) {
            if (strArray[lb] == "") {
                lb++;
                continue;
            }

            if (strArray[ub] == "") {
                lb--;
                continue;
            }

            String temp = strArray[lb];
            strArray[lb] = strArray[ub];
            strArray[ub] = temp;
            lb++;
            ub--;
        }

        StringBuilder result = new StringBuilder();
        for (String str: strArray) {

            if (!str.equals("")) {
                result.append(str);
                result.append(" ");
            }

        }


        return result.toString().trim();
    }
}
