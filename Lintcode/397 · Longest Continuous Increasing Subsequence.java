public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        //state: dp[i]: 代表以A[i]结尾的最长的连续子序列的长度
         int n = A.length;
         int[] dp = new int[n];

        // left to right
         int result1 = LICS(A, n);

         //right to left
         int i = 0, j = n - 1;
         while (i < j) {
           int temp = A[i];
           A[i] = A[j];
           A[j] = temp;
           i++;
           j--;
         }
          int result2 = LICS(A, n);
          return result1 > result2 ? result1 : result2;
    }

    private int LICS(int[] A, int n) {
      //state: dp[i]: 代表以A[i]结尾的最长的连续子序列的长度
      int[] dp = new int[n];
      int res = 0;
      for (int i = 0; i < n; i++) {
        //case 1
        dp[i] = 1;

        //case 2
        if (i > 0 && A[i] > A[i - 1]) {
          dp[i] = dp[i - 1] + 1;
        }
        res = Math.max(dp[i], res);
      }
      return res;
    }
}