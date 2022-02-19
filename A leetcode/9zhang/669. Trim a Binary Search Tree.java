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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //recursive
        //出口
        if (root == null) {
            return root;
        }
        int value = root.val;
        //1.当前的root合法，可以继续修剪左边和右边，并且把修剪完的拼接回来
        if (value <= high && value >= low) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            //拼接回来并返回
            return root;
        }
        if (value > high) {
            //说明右边完全不要了，根和右边都不合格，直接返回左边子树
            return trimBST(root.left, low, high);    
        }
        //说明左边完全不要了，根和左边都不合格，直接返回右边子树
        return trimBST(root.right, low, high); 
        
        
    }
}