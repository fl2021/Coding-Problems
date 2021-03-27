public class Solution {
    /**
     * @param nums: the given array
     * @param s: the given target
     * @return: the number of ways to assign symbols to make sum of integers equal to target S
     */
    public int count = 0;
    public int findTargetSumWays(int[] nums, int s) {
        // Write your code here
        if (nums == null) {
            return 0;
        }

        dfs(nums, s, 0);
        return count;
    }

    private void dfs(int[] nums, int s, int startIndex) {
        if (startIndex == nums.length && s == 0) {
            count++;
            return;
        }

        if (startIndex < nums.length) {
            dfs(nums, s + nums[startIndex], startIndex + 1);
            dfs(nums, s - nums[startIndex], startIndex + 1);
        }
    }
        
}