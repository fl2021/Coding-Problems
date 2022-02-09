class Solution {
    public int myAtoi(String s) {
        if (s == null | s.length() == 0) {
            return 0;
        }
        int sign = 1;
        //Discard all spaces from the beginning of the input string.
        s = s.trim();
        int i = 0;
        int n = s.length();
        int res = 0;
        
        //sign = +1, if it's positive number, otherwise sign = -1. 
        if (i < n && s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (i < n && s.charAt(i) == '+') {
                sign = 1;
                i++;
            }        
        //Traverse next digits of input stop if it is not a digit
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            //check overflow and underflow conditions.
            if ((res > Integer.MAX_VALUE /10 ) || (res == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res* 10 + digit;
            i++;
        }  
        return res*sign;
    }
}