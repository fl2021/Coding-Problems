public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
    public int[] rotate(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) {
          return nums;
        }
        int n = nums.length;
        int[] res = new int[n];//定义新的数组不要忘记了定义长度，这个错误屡次出现了。
        if (k % n == 0) {
          return nums;
        } 
        k %= n; //实际上k是可以大于数列长度的，整除出来的数字才是实际上要移动的
          for (int i = 0; i < n; i++) {
            if (i < k) {
              //分情况讨论，前半段和后半段，以k为界
            res[i] = nums[n - k + i];
            } else {
            res[i] = nums[i - k];
            }
          }
        return res;
    }
}

// [1, 2, 3, 4, 5, 6, 7]
//  0  1  2  3  4  5  6
// [5, 6, 7, 1, 2, 3, 4]
//  0  1  2  3  4  5  6