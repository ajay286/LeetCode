class AllDuplicatesInAnArray {
    List < Integer > result = new ArrayList < Integer > ();
    public List < Integer > findDuplicates(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] >= 0)
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            else {
                result.add(Math.abs(nums[i]));
            }

        }

        return result;

    }
}
