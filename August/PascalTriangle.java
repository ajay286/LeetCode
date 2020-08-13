class PascalTriangle {
    public List < Integer > getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 1);
        for (int i = 0; i < rowIndex; ++i) {
            for (int j = i; j > 0; --j) {
                result[j] += result[j - 1];
            }
        }

        return new ArrayList < Integer > (Arrays.asList(result));
    }
}
