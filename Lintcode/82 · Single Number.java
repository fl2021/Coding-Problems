public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
          return -1;
        }
        int j = 0;
        for (int i = 0; i < A.length; i++) {
          j^= A[i];
        }
        return j;
    }
}