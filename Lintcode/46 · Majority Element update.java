public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        //O(n) time and O(1) extra space
        int count = 0;
        int majorNum = 0;
        for (Integer num : nums) {
          if (count == 0) {
            majorNum = num;
          }
          if (majorNum == num) {
            count++;
          } else {
            count--;
          }
        }
        return majorNum;
    }
}
//[1, 1, 1, 1, 2, 2, 2]
//m = 1;c=4; m=2;c=3