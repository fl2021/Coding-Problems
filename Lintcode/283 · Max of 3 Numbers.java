public class Solution {
    /**
     * @param num1: An integer
     * @param num2: An integer
     * @param num3: An integer
     * @return: an interger
     */
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // write your code here
        int max1 = Math.max(num1, num2);
        int max2 = Math.max(num2, num3);
        return Math.max(max1, max2);
    }
}