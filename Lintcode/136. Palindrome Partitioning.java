public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // 模拟切割字符串可能出现的位置，来进行dfs
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        List<String> temp = new ArrayList<>();
        dfs(s, temp, results);
        return results;
    }

    private void dfs(String s, List<String> temp,
                    List<List<String>> results) {
        if (s.length() == 0) {
            results.add(new ArrayList<String>(temp));
            return;
        }
        // a|ab aa|b aab|                
        for (int i = 1; i < s.length() + 1;i++) {
            String subStr = s.substring(0, i);
            if (isPalindrome(subStr)) {
                temp.add(subStr);
                dfs(s.substring(i, s.length()), temp, results);
                temp.remove(temp.size() - 1);
            }
        }                
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
         return true;
    }
}