class ExcelColumnNumber {
    public int titleToNumber(String s) {

        int result = 0;
        int counter = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            ++counter;
            result += Math.pow(26, (counter - 1)) * ((int) s.charAt(i) - (int)
                'A' + 1);
        }

        return result;
    }
}
