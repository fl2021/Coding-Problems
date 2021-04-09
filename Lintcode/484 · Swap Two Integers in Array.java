public class Solution {
    /**
     * @param A: An integer array
     * @param index1: the first index
     * @param index2: the second index
     * @return: nothing
     */
    public void swapIntegers(int[] A, int index1, int index2) {
        // write your code here
        if (A == null || A.length == 0) {
          return;
        }
        if (index1 > A.length - 1 || index2 > A.length - 1) {
          return;
        }
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}