public class Solution {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length <= 2) {
          return 0;
        }
        int result = 0;
        
        int left = 0, right = heights.length - 1;
        int maxL = heights[0];
        int maxR = heights[right];
        while (left < right) {
          if (maxL < maxR) {
            left++;
            if (heights[left] < maxL) {
              result += maxL - heights[left];
            } else {
              maxL = heights[left];
            }
          } else {
            right--;
            if (heights[right] < maxR) {
              result += maxR - heights[right];
            } else {
              maxR = heights[right];
            }
          }
        }
        return result;
    }
}  