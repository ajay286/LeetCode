class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum ^= num;

        int lbit = sum & (-sum);
        int[] result = new int[2];

        for (int num: nums) {
            if ((num & lbit) > 0)
                result[0] ^= num;
            else
                result[1] ^= num;

        }

        return result;

    }
}
