public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        String[] re = s.trim().split(" +");
    
        for (int start = 0, end = re.length - 1;start < end; start++, end--) {
            String temp = re[start];
            re[start] = re[end];
            re[end] = temp;
        }
        
    return String.join(" ", re);    
    }
}