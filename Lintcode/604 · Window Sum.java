public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k) {
          return new int[]{};
        }

        if (k == 0) {
          return new int[nums.length];
        }

        int[] results = new int[nums.length - k + 1];
        int j = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && j - i < k) {
              sum += nums[j];
              j++;
            }
            if (j - i == k) {
              results[i] = sum;
            }
            sum -= nums[i];
        }

        return results;
    }
}