public class Solution {
    /**
     * @param nums: An integer array
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;
         
        while (left < right && nums[left] < nums[right]) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp; 
            left++;
            right--;
          }
        
        return nums[1];
    }
}