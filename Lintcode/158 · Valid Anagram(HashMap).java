public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        //key: char; value: count 
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          // if (map.containsKey(c)) {
          //     map.put(c, map.get(c) + 1);
          // }else {
          //   map.put(c, 1);
          // }
          map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
          char c = t.charAt(i);
          if (map.containsKey(c)) {
            map.put(c, map.get(c) - 1);
          } else {
            return false;
          }
        }

        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (map.get(c) != 0) {
            return false;
          }
        }
        return true;
    }
}
//time: O(n);
//space: O(n)