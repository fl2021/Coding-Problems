public class Solution {
    /**
     * @param s: A string
     * @return: the length of last word
     */
    public int lengthOfLastWord(String s) {
        // write your code here
        s = s.trim();
        int last = s.length() - 1;
        int count = 0;
        for (int i = last; i >= 0; i--) {
          
            if (s.charAt(i) != ' ') {
              count++;
            }
            if (s.charAt(i) == ' ') {
              break;
            }
        }
        return count;

    }
}