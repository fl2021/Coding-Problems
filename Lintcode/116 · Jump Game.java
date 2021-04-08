public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
   
   public boolean canJump(int[] A) {
        // state: dp[j]：青蛙能不能调到位置j
        boolean[] dp = new boolean[A.length];
        
        // initialization
        dp[0] = true;
        //function: dp[j] = (for(0, j) -> i -> sayisfy(dp[i]&&j - i <= A[i]))
        
        for (int j = 1; j < A.length; j++) {
          //last jump from i to j
            for (int i = 0; i < j; i++) {
                if (dp[i] && j - i <= A[i]) {
                    dp[j] = true;
                    break;
                }
            }
        }
        // answer: dp[A.length - 1]
        return dp[A.length - 1];
    }
}