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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        return Invert(root);
    }
    private void Invert(TreeNode root) {
      if (root == null) {
        return; 
      }
      int temp = root.left;
      root.left = root.right;
      root.right = temp;
    }
}