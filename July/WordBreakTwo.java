class WordBreakTwo {
    HashMap < String, List < String >> tempResults = new HashMap < String, List < String >> ();
    public List < String > wordBreak(String s, List < String > wordDict) {
        List < String > result = new ArrayList < String > ();
        if (tempResults.containsKey(s))
            return tempResults.get(s);


        for (String word: wordDict) {

            if (word.length() <= s.length() && s.substring(0, word.length()).equals(word)) {


                if (s.length() == word.length()) {
                    result.add(word);
                } else {
                    List < String > leftOverStringResult = this.wordBreak(s.substring(word.length(), s.length()), wordDict);
                    for (String recResult: leftOverStringResult) {
                        result.add(word + " " + recResult);
                    }

                }

            }

        }
        tempResults.put(s, result);

        return result;
    }
}
