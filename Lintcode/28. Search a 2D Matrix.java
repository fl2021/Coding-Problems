public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int row = matrix.length;
        int column = matrix[0].length;
        int n = row * column;
        if (n == 0) {
            return false;
        }
        int start = 0, end = n - 1;
        int mid;
        
        while ( start + 1 < end) {
            mid = start + (end - start) / 2;
            int r = mid / column;
            int c = mid % column;
            if ( matrix[r][c] == target ) {
                return true;
            } else if (matrix[r][c] < target) {
                start = mid;
            } else if (matrix[r][c] > target) {
                end = mid;
            }
        }
        if (matrix[start / column][start % column] == target) {
            return true;
        }
          if (matrix[end / column][end % column] == target) {
            return true;
        }
        return false;
    }
}