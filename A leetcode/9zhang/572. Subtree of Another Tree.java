/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 空树是任何树的子树
        if (subRoot == null) {
            return true;
        }
        //非空树必定不是空树的子树
        if (root == null) {
            return false;
        }
        //如果两树完全相同（val相同），则互为子树
        if (isEqual(root, subRoot)) {
            return true;
        }
        //subroot可能是root的左子树的子树或者右子树的子树
        return isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot); 
    }
    private boolean isEqual(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            //两空树完全相同
            return true;
        }
         if (T1 == null || T2 == null) {
             //俩者有一个是空树，一个不是空树
            return false;
        }
        //判断节点的value
        if (T1.val != T2.val) {
            return false;
        }
        //递归判断T1的左子树和T2的左子树是否完全一样,右子树同理
        return isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }
    
}