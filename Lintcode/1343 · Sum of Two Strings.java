public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: return the sum of two strings
     */
    public String SumofTwoStrings(String A, String B) {
        // write your code here
        if (A == null || A.length() < 1) return B;
        if (B == null || B.length() < 1) return A;
        
        if (A.length() < B.length()) {
            String tmp = A;
            A = B;
            B = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        final int n = A.length();
        final int m = B.length();
        
        for (int i = 0, j = 0; i < n; i++) {
            sb.append (i < n - m ? A.charAt(i) - '0'
                     : (A.charAt(i) - '0') + (B.charAt(j++) - '0'));
        } 
        return sb.toString();
    }
}