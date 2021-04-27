public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        int extra = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + extra;
            digits[i] = sum % 10;
            extra = sum / 10;
            if (extra == 0) {
                break;
            }
        }
        if (extra == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}