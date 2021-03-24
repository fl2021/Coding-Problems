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
     * @param root: The root of the BST
     * @param key: The number needed to be deleted
     * @return: The root of the BST
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // write your code here
        if (root == null) {
            return null;
        }
        //find target node
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        //guarantee root!= null && root.val == key
        if (root.left == null) {
            return root.right;
        } else if(root.right == null) {
            return root.left;
        }

        //guarantee root.left != null && root.val == key
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        //find and delete the smallest node in root.right
        TreeNode smallest = deleteSmallest(root.right);
        //connect the smallest node with root.left and root.right
        smallest.left = root.left;
        smallest.right = root.right;
        //return the smallest node.
        return smallest;
    }

    private TreeNode deleteSmallest(TreeNode cur) {
        TreeNode prev = cur;
        cur = cur.left;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        //cur is the smallest one, and the prev is its parent.
        //invariance: cur(prev.left) does not have left child
        prev.left = prev.left.right;
        return cur;
    }
}