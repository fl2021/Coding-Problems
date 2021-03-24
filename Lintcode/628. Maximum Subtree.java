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
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        TreeNode[] result = new TreeNode[1];
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        divideConquer(root, result, maxSum);
        return result[0];
    }

    private int divideConquer(TreeNode root, TreeNode[] result, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int left = divideConquer(root.left, result, maxSum);
        int right = divideConquer(root.right, result, maxSum);
        int sum = left + right + root.val;

        if (sum > maxSum[0]) {
            maxSum[0] = sum;
            result[0] = root;
        }
        return sum;
    }
}