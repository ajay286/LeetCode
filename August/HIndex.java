class HIndex {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int lb = 0, ub = citations.length - 1;

        while (lb <= ub) {
            int mid = (lb + ub) / 2;

            if (citations[mid] == citations.length - mid)
                return citations[mid];
            else if (citations[mid] < citations.length - mid)
                lb = mid + 1;
            else
                ub = mid - 1;

        }

        return citations.length - ub - 1;
    }
}
