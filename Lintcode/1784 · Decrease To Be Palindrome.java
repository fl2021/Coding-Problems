public class Solution {
    /**
     * @param s: the string s
     * @return: the number of operations at least
     */
    public int numberOfOperations(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
          return 0;
        }

        int result = 0;
        int left = 0, right = s.length() - 1;

        while (left < right) {
          if (s.charAt(left) != s.charAt(right)) {
            result += Math.abs(s.charAt(right) - s.charAt(left));
          }
          left++;
          right--;
        }
        return result;
    }
}