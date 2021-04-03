public class Solution {
    /**
     * @param target: A string
     * @return: An integer
     */
    public int stringToInteger(String target) {
        // write your code here
        int sign = 1;
        if (target.charAt(0) == '-') {
            sign = -1;
            target = target.substring(1, target.length());
        }
        int result = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            result = result * 10 + (c - '0');
        }
        return result * sign;
    }
}