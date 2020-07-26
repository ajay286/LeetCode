class RotatedSortedArrayII {
    public int findMin(int[] nums) {

        return findMinUtil(nums, 0, nums.length - 1);

    }

    int findMinUtil(int[] arr, int lb, int ub) {
        if (lb == ub) {
            return arr[lb];
        }
        int mid = lb + (ub - lb) / 2;
        int result = Integer.MAX_VALUE;
        if (arr[lb] < arr[mid]) {
            result = Math.min(arr[lb], findMinUtil(arr, mid, ub));
        } else if (arr[ub] > arr[mid]) {
            result = Math.min(arr[mid], findMinUtil(arr, lb, mid));
        } else if (arr[lb] == arr[mid]) {
            result = Math.min(arr[lb], findMinUtil(arr, lb + 1, ub));
        } else if (arr[ub] == arr[mid]) {
            result = Math.min(arr[ub], findMinUtil(arr, lb, ub - 1));
        }
        return result;
    }

}
