public class Solution {
    /**
     * @param s: a string
     * @return: return a boolean
     */

    public boolean repeatedSubstringPattern(String s) {
        // write your code here
        for (int i = 1; i <= s.length() / 2; i++) {    
          if (s.length() % i != 0) {
            continue;
          }
          String str = s.substring(0, i);
          int j = i;
          while (j < s.length()) {
                if (!str.equals(s.substring(j, j + i))) {
                  break;
                }
                j+=i;
            }
            if (j == s.length()) {
                return true;
            }
        }
         return false;               
    }
}