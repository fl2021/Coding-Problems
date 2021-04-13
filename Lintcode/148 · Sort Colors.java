public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int pl = 0;
        int pr = nums.length - 1;
        int i = 0;
        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, pl, i);
                pl++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, pr, i);
                pr--;
            }
        }
    }
    
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}