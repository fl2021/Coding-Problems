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
    //所有path中的最大路径和，每次一步步更新
    private int maxSum = Integer.MIN_VALUE;
    //代表以node为最高点的路径最大值
    //此处的maxsum是类的变量，类的变量运用是类
    private int helper(TreeNode node) {
        //如果节点为null，返回0
        if (node == null) {
            return 0;
        }
        //分治左和右，分别算出以左/右孩子为最高点的路径最大值
        int maxLeft = helper(node.left);
        int maxRight = helper(node.right);
        //以node为最高点 穿过左右和node的最大路径和
        maxSum = Math.max(maxSum, maxLeft + maxRight + node.val);
        
        int currentMax = Math.max(maxLeft, maxRight) + node.val;
        //可能是负数，如果是负数，那不取
        return currentMax > 0 ? currentMax : 0;
    }
    public int maxPathSum(TreeNode root) {
        //异常检测
        if (root == null) {
            return 0;
        }
        helper(root);
        return maxSum;
        
    }
}

//currentmax记录的是单链的,maxsum记录的是整个路径的, currentmax是单链，不会转弯的,maxsum是可能会转弯的
//maxsum计算maxleft+maxright+node.val,这个maxleft和maxright就是你左右节点的currentmax返回上来的呀
//https://www.runoob.com/java/java-variable-types.html
