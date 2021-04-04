public class Solution {
    /**
     * @param s: the string s
     * @param k: the maximum length of substring
     * @return: return the least number of substring
     */
    public int getAns(String s, int k) {
        // Write your code here
      int result = 1;
      int count = 1;
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i - 1)) {
          if (count < k) {
            count++;
          } else if (count == k) {
            count = 1;
            result++;
          }
            
        } else {
          count = 1;
          result++;
        }
      }
      return result;
    }    
}


