class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        int len = 0;
        //s = "babad"
        //     01234
        //s = "cbbd"
        //     0123
        for (int i = 0; i < s.length(); i++) {
    
            len = findLongest(s,i,i);
            if (len > max) {
                max = len;
              start = i - len/2;
            }
            
            len = findLongest(s,i,i+1);
            if (len > max) {
              max = len;
              start = i - len/2 + 1;
            }
            
        }
        int end = start + max;
        return s.substring(start, end);
        
    }
    private int findLongest(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            len = right - left + 1;
            left--;
            right++;
        }
        return len;
    }
}
//中心枚举法
//O(n^2)
//注意点：分为奇数和偶数字符串的区别

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        int longest = 1, start = 0;
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalindrome[i][i + 1]) {
                start = i;
                longest = 2;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && 
                    s.charAt(i) == s.charAt(j);
                    
                if (isPalindrome[i][j] && j - i + 1 > longest) {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }
        
        return s.substring(start, start + longest);
    }
}

//基于动态规划的算法，时间复杂度 O(n^2)，但是会耗费额外的 O(n^2) 的空间复杂度