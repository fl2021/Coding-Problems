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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, lists);
        return lists;
    }
    
    //后根遍历，先左孩子，再右孩子，最后父亲
    private int dfs(TreeNode node, List<List<Integer>> lists) {
        if (node == null) {
            //返回-1很巧妙，父节点+1后会变成第0层。
            return -1;
        }
        int leftLevel = dfs(node.left, lists);
        int rightLevel = dfs(node.right, lists);
        
        //当前的level = 左右孩子level的最大值+1
        int currLevel = Math.max(leftLevel, rightLevel) + 1;
        addIntoLists(lists, currLevel, node.val); 
        return currLevel;
    }
    
    //把某个节点的值加入某一层
     private void addIntoLists(List<List<Integer>> lists, int level, int value) {
         //如果lists还没有第level层，加入一层
         if (level == lists.size()) {
             List<Integer> list = new ArrayList<>();
             lists.add(list);
         }
         lists.get(level).add(value);
     }
}