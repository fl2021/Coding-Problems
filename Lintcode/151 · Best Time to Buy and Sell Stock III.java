public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
          return 0;
        }
        //state: dp[i][j]代表：前i天结束后，处于阶段j的，最大收益
        int n = prices.length;
        int[][] dp = new int[n + 1][5 + 1];

        //initialization
        dp[0][1] = 0;
        for (int i = 2; i <= 5; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }

        //function:
        //dp[i][j] 第1、3、5阶段 = max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2])
        //dp[i][j] 第2、4阶段 = max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i - 1][j - 1])
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j += 2) {
              dp[i][j] = dp[i - 1][j];
              //阶段1、3、5
              if (j > 1 && i >= 2 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
              dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
              }
            }

            for (int j = 2; j <= 5; j += 2) {
              //阶段2、4
              dp[i][j] = dp[i - 1][j - 1];
              if (i >= 2 && dp[i - 1][j] != Integer.MIN_VALUE) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
              }
            }
        }

        //answer: max(dp[n][1], dp[n][3], dp[n][5])
        return Math.max(Math.max(dp[n][1], dp[n][3]), dp[n][5]);
    }
}