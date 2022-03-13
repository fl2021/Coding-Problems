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