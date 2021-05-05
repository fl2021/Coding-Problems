public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
          if (!set.contains(c)) {
            set.add(c);
          } else {
          set.remove(c);
          count += 2;
          }
        }
        if (!set.isEmpty()) {
          count++;
        }
        return count;
    }
}