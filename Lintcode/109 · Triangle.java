public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // state:dp[i][j]：从（0，0）走到（i，j）的最短路径值
        //此处易出错，因为是三角形不是正方形，每行的列数是不一样的，取最大的一个列数
        int m = triangle.length;
        int n = triangle[m - 1].length;
        int[][] dp = new int[m][n];

        //initialization: 三角形的左边和右边都要初始化，因为它们分别没有左上角和右上角的点
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < m; i++) {
          dp[i][0] = dp[i - 1][0] + triangle[i][0];
          dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        //function: dp[i][j] = min(dp[i-1][j-1], dp[i- 1][j]) + triangle[i][j];
        //此次列数每次都会改变所以用行数来控制它，因为在这个三角形里面行数=最大列数
        for (int i = 2; i < m; i++) {
          for (int j = 1; j < i; j++) {
            dp[i][j] = Math.min(dp[i-1][j-1], dp[i- 1][j]) + triangle[i][j];
          }
        }

        //answer: min(dp[n - 1])
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result,dp[m-1][i]);
        }
        return result;
    }
}