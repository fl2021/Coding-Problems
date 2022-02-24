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

class Solution {
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        //把所有的数字全加起来，然后减掉最小的数字*长度
        
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }
        
        return moves - min * nums.length;  
    }
}
//Time complexity : O(n)O(n). We traverse the complete array once.
//Space complexity : O(1)O(1). No extra space required