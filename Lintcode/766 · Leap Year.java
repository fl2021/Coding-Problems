

public class Solution {
    /**
     * @param n: a number represent year
     * @return: whether year n is a leap year.
     */
    public boolean isLeapYear(int n) {
        // 1. leap year must be divisible by 4 and either not divisible by 100 or is divisible by 400
        return (n % 4 == 0 && (n % 100 != 0 || n % 400 == 0));
    }
}