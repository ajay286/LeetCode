class SortArrayByParitySolution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i <= j) {
            if (A[i] % 2 == 0) {
                ++i;
                continue;
            } else {
                if (A[j] % 2 == 0) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    ++i;
                    --j;
                } else {
                    --j;
                }
            }

        }

        return A;
    }
}
