/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        TreeNode[] result = new TreeNode[1];
        int[] minSum = new int[1];
        minSum[0] = Integer.MAX_VALUE;
        divideConquer(root, result, minSum);
        return result[0];
    }

    private int divideConquer(TreeNode root, TreeNode[] result, int[] minSum) {
        if (root == null) {
            return 0;
        }

        int left = divideConquer(root.left, result, minSum);
        int right = divideConquer(root.right, result, minSum);
        int sum = left + right + root.val;

        if (sum < minSum[0]) {
            minSum[0] = sum;
            result[0] = root;   
        }
        return sum;
    } 
}