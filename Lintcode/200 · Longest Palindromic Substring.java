public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        String result = null;
        for (int start = 0; start < len; start++) {
            for (int end = start; end < len; end++) {
                // 小优化
                if (end - start + 1 <= maxLen) {
                    continue;
                }
                
                // 如果是回文串的话，更新答案
                if (isPalindrome(s, start, end)) {
                    maxLen = end - start + 1;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = 0; start + i < end - i; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
}