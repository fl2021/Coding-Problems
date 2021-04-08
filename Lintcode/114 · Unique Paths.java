ublic class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // state： dp[i][j]:从左上角走到当前位置（i，j）有多少种unique方式
        int[][] dp = new int[m][n];

        //initialization:
        for (int i = 0; i < m; i++) {
          dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
          dp[0][j] = 1;
        }

        //function: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        //answer:dp[m - 1][n - 1];
        return dp[m - 1][n - 1];
    }
}