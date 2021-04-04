public class Solution {
    /**
     * @param words: word list
     * @param pattern: pattern string
     * @return: list of matching words
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // Write your code here.
        List<String> results = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) {
                results.add(word);
            }
        }
        return results;
    }

    private boolean check(String s, String p) {
      if (s.length() != p.length()) {
        return false;
      }

      Map<Character, Integer> map1 = new HashMap<>();
      Map<Character, Integer> map2 = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        if (!Objects.equals(map1.put(s.charAt(i), i), map2.put(p.charAt(i), i))) {
          return false;
        }
      }
      return true;
    }
}