public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // state:dp[i]:以nums[i]结尾的子数组的最大乘积
        //       dp[j]:以nums[j]结尾的子数组的最小乘积

        int n = nums.length;
        int[] dp = new int[n];
        int[] gp = new int[n];

        //initialization

        //function:
        //dp[i] = Math.max(nums[i], Math.max(nums[i]*dp[i - 1],nums[i] * gp[i - 1]))
        //gp[i] = Math.min(nums[i], Math.min(nums[i]*dp[i - 1],nums[i] * gp[i - 1]))
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
          dp[i] = nums[i];
          if (i > 0) {
            dp[i] = Math.max(dp[i], Math.max(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
          }

          gp[i] = nums[i];
          if (i > 0) {
            gp[i] = Math.min(gp[i], Math.min(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
          }
          result = Math.max(result, dp[i]);
        }

        //answer:
        return result;
        
    }
}