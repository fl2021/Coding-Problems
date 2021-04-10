public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0) {
          return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //state: dp[i][j]代表从起点走到当前位置（i，j）的路径数
        int[][] dp = new int[m][n];

        //initialization
        for (int i = 0; i < n; i++) {
          if (obstacleGrid[0][i] == 1) {
            break;
          }
          dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
          if (obstacleGrid[i][0] == 1) {
            break;
          }
          dp[i][0] = 1;
        }
        //function:dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
            if (obstacleGrid[i][j] == 1) {
              continue;
            }
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
          }
        }

        //answers:dp[m - 1][n - 1]
        return dp[m - 1][n - 1];
    }
}