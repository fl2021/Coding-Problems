public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] count = new int[256];

        for (char c : A.toCharArray()) {
          count[c]++;
        }
        for (char c : B.toCharArray()) {
          count[c]--;
          if (count[c] < 0) {
            return false;
          }
        }
        return true;
    }
  }  