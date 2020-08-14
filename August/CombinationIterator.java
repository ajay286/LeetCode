class CombinationGenerator {
    public static void generateCombination(String characters, int combinationLength, List < String > combinationList, int index, StringBuffer outstr) {

        for (int i = index; i < characters.length(); i++) {
            outstr.append(characters.charAt(i));
            if (outstr.length() == combinationLength)
                combinationList.add(outstr.toString());

            generateCombination(characters, combinationLength, combinationList, i + 1, outstr);
            outstr.deleteCharAt(outstr.length() - 1);
        }

    }
}

class CombinationIterator {
    private List < String > combinations;
    private int currentIndex = -1;
    private int lastIndex = -1;
    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList < String > ();
        CombinationGenerator.generateCombination(characters, combinationLength, combinations, 0, new StringBuffer());

        if (combinations.size() > 0) {
            currentIndex = 0;
            lastIndex = combinations.size() - 1;
        }


    }


    public String next() {
        String result = combinations.get(currentIndex);
        ++currentIndex;
        return result;
    }

    public boolean hasNext() {
        return currentIndex <= lastIndex;
    }


}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
