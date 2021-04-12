public class Solution {
    /**
     * @param nums: the list of numbers
     * @return: return the maximum number.
     */
    public int maxNum(List<Integer> nums) {
        // write your code here
        int max = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
           max = Math.max(max, nums.get(i));
        }
      return max;
    }
}