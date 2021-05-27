class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int start = 0;
        int max = 0;
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
            
        }
        return max;
    }
}