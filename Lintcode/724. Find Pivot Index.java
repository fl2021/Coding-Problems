class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int total = 0;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0;i < nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return i;
            }
            sum = sum - nums[i];
        }
        return - 1;      
    }
}