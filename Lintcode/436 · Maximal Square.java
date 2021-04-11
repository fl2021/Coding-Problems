public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        //state:以当前位置(i, j)为结尾的最大正方形的边长是多少
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        //initialization：第一行；第一列；

        //function: dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
        int max = 0;
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            if (i == 0 || j == 0) {
              if (matrix[i][j] == 1) {
                  dp[i][j] = 1;
              }
            } else {
               if (matrix[i][j] == 1) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
            }
           
            max = Math.max(max, dp[i][j]);
          }
        }
        //answer: max*max
        return max*max;
    }
}