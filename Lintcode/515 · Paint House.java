public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        //state: dp[i][j]表示前i栋房子，涂色为j的，最小花费
        int n = costs.length;
        int[][] dp = new int[n + 1][3];

        //initialization
        dp[0][0] = dp[0][1] = dp[0][2] = 0;

        //function: dp[i][j] = min(dp[i - 1][k], where k != j) + costs[i - 1][j]
        for (int i = 1; i <= n; i++) {
          // house i - 1, which color j
            for (int j = 0; j < 3; j++) {
              dp[i][j] = Integer.MAX_VALUE;
              // house i - 2, with color k
              for (int k = 0; k < 3; k++) {
                if (j != k) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][j]);
                }
              }
            }
        }
        // answer: min(dp[n][0], dp[n][1], dp[n][2])
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }
}