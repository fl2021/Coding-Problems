public class Solution {
    /**
     * @param A: the given array
     * @return: the minimum sum of a falling path
     */
    public int minFallingPathSum(int[][] A) {
        // Write your code here
        //state : define dp[i][j] as the minimum sum of the first element to the [i,j]
        int m = A.length;
        // int n = A[0].length;
        int[][] dp = new int[m][m];

      //initialization
      for (int i = 0; i < m; i++) {
          dp[0][i] = A[0][i];
      }
      // dp[0][0] = A[0][0];
      // for (int i = 1; i < m; i++) {
      //   dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + A[i][0];
      //   dp[i][i] = Math.min(dp[i - 1][i], dp[i - 1][i - 1]) + A[i][i];
      // }
      
      //function: dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) + A[i][j];
      for (int i = 1; i < m; i++) {
        for (int j = 0; j < m; j++) {
          if (j == 0) {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
            continue;
          }
          if (j == m - 1) {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
            continue;
          }
          dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]) + A[i][j];
        }
      }
      //answer: dp[m][?]
      int result = dp[m - 1][0];
      for (int i = 1; i < m; i++) {
          result = Math.min(result, dp[m - 1][i]);
      }
      return result;
    }
}


// [1, 2, 3]
// [4, 5, 6]
// [7, 8, 9]