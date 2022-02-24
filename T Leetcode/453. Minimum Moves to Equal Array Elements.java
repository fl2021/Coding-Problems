class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        //everytime only one number can decrease one, so can just use the largest number to decrease to the lowest number.
        for (int i = nums.length - 1; i > 0; i--) {
                res+= nums[i] - nums[0];           
        }
        return res;
    }
}
// Time complexity : O\big(nlog(n)\big)O(nlog(n)). Sorting will take O\big(nlog(n)\big)O(nlog(n)) time.
// Space complexity : O(1)O(1). No extra space required.