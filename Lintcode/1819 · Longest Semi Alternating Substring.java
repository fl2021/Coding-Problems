public class Solution {
    /**
     * @param s: the string
     * @return: length of longest semi alternating substring
     */
    public int longestSemiAlternatingSubstring(String s) {
        // write your code here
        int longestLen = 0;
        int count = 1;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);
            if (currChar != prevChar) {
              count = 1;
            } else {
              count++;
              if (count >= 3) {
                  j = i - 1;
                  //count--;
              }
            }
            longestLen = Math.max(longestLen, i - j + 1);
        }
        return longestLen;
    }
}