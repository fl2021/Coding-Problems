public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        Collections.sort(nums);
        int length = nums.size();
        return nums.get((length - 1) / 2);
    }
}