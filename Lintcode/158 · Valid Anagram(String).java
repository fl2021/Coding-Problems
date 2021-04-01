public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
          count[c]++;
        }
        for (char c : t.toCharArray()) {
          count[c]--;
        }
        for (int i = 0; i < 256; i++) {
          if (count[i] != 0) {
            return false;
          }
        }
        return true;
    }
}
// Time: O(n);
// space: O(1);