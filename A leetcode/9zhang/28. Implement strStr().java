class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals(haystack)) {
            return 0;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean notEqual = false;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    notEqual = true;
                    break;
                }
            }
            if (notEqual == false) {
                return i;
            }
        }
        return -1;     
        
    }
}
//O(n^2) 引入了一个flag boolean来记录位置

class Solution {
    public int strStr(String haystack, String needle) {
       
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;     
        
    }
}
// 一开始i的范围没想到是要减去那个needle的长度的，所以一直不对。
