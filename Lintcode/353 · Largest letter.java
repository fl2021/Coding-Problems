public class Solution {
    /**
     * @param s: a string
     * @return: a string
     */
    public String largestLetter(String s) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
          if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a' ) {
            map.put(s.charAt(i) - 'a' + 32, map.getOrDefault(s.charAt(i) - 'a' + 32, 0) + 1);
          }
          if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A' ) {
            map.put(s.charAt(i) - 'A', map.getOrDefault(s.charAt(i) - 'A', 0) + 1);
          }
        }
        for (int key = 25 ;key >= 0; key--) {
          if (map.containsKey(key) && map.containsKey(key + 32)) {
            return ("" +(char)(key + 65));
          }
        }
        return "NO";
    }
}