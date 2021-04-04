public class Solution {
    /**
     * @param s: string S
     * @param t: string T
     * @return: whether S can convert to T
     */
    public boolean canConvert(String s, String t) {
        // Write your code here
        if (t == null || s == null || t.length() == 0 || s.length() == 0) {
            return false;
        }
        if (t.length() > s.length()) {
            return false;
        }
        int j = 0;
        int i = 0;
        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {   
                i++;
                j++;
            } else i++;
        }
        return j == t.length(); 
        }
    }
