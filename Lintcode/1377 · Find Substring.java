public class Solution {
    /**
     * @param str: The string
     * @param k: The length of the substring
     * @return: The answer
     */
    public int findSubstring(String str, int k) {
        // Write your code here
        if (str == null || k > str.length()) {
          return 0;
        }
        int result = 0;
        Set<String> res = new HashSet<String>();
        for (int i = 0; i + k - 1 < str.length(); i++) {
          Set<Character> set = new HashSet<Character>();
          boolean flag = true;
          for (int j = i; j <= i + k - 1; j++) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
            } else {
              flag = false;
              break;
            }
          }
          if (flag == true) {
            if (!res.contains(str.substring(i, i + k))) {
              res.add(str.substring(i, i + k));
              result++;
            } else {
              continue;
            }
          }
      }
      return result;
    }
}