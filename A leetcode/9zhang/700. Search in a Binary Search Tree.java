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
    public TreeNode searchBST(TreeNode root, int val) {
        //recursive
        //递归三要素之一：递归的出口
        //exit
        if (root == null || root.val == val) {
            return root;
        }
        //split
        //递归三要素之二：递归的拆解
        //val在root左子树
        if (root.val < val) {
            return searchBST(root.right, val);
        } 
        //val在root右子树
        else {
            return searchBST(root.left, val);
        }
       
    }
}

//iteration
public TreeNode searchBST(TreeNode root, int val) {
        //如果还可以继续往下找，并且还没找到，就继续找
        while (root != null || root.val != val) {
            //val在左子树
            if (val < root.val) {
                root = root.left;
            }
            //val在右子树
            else {
                root = root.right;
            }
        }
        return root;
    }
