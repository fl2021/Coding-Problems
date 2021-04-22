public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        int[] res = new int[52];
        int[] Res = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c >= 'a') {
              res[c - 'a']++;
            } else {
              Res[c - 'A']++;
          }
        }
        int len = s.length();
        for (int i = 0; i < 52; i++) {
          if (res[i] % 2 == 1) {
            len--;
          }
          if (Res[i] % 2 == 1) {
            len--;
          }
        }
        return len == s.length() ? len : len + 1;
    }
}
//only one different letter can be the odd amount, the others have to be the even amounts