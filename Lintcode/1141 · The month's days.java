public class Solution {
    /**
     * @param year: a number year
     * @param month: a number month
     * @return: Given the year and the month, return the number of days of the month.
     */
    public int getTheMonthDays(int year, int month) {
        // write your code here
        int[] mdays = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2) {
          if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return 29;
          }
        }
        return mdays[month];
    }
}