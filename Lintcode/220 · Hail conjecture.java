public class Solution {
    /**
     * @param num: an integer
     * @return: return an integer
     */
    public int getAnswer(int num) {
        // write your code here.
        if (num == 0 || num == 1) {
          return 0;
        }
        int count = 0;
        while ( num > 1) {
          if (num % 2 == 0) {
              num /= 2;
              count++;
          } else {
            num = 3 * num + 1;
            count++;
          }
       }
       return count;      
    }
}