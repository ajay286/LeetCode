public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        
        if (nums.length <= 1) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] > 0) {
                nums[Math.abs(nums[i])]= -1 * nums[Math.abs(nums[i])];
            } 
            else {
                return Math.abs(nums[i]);
            }
        }

        return 0;
        
    }
}
