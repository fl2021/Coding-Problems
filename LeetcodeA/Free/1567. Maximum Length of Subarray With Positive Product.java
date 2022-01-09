class Solution {
    public int getMaxLen(int[] nums) {
        // use max to record the maximum length of the subarray with positive product
        int max = 0;
        // use i as the starter pointer
        for (int i = 0; i < nums.length; i++) {
            // if the left length already <= max length, we can stop calculate
            if (nums.length - i <= max) {
                return max;
            }
            // if the starter is 0, we will simply go to next one
            // will only start counting the length when it's not 0
            if (nums[i] != 0) {
                int negatives = nums[i] > 0 ? 0 : 1;
                max = Math.max(max,nums[i] > 0 ? 1 : 0);
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < 0) {
                        negatives++;
                    } else if (nums[j] == 0) {
                        break;
                    }
                    if (negatives % 2 == 0) {
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
        }
        return max;
    }
}