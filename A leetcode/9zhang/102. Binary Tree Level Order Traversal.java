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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Breadth First Search (BFS)
        //We scan through the tree level by level
        //we can create an arraylist to store the final result
        List<List<Integer>> res = new ArrayList<>();
        //then create a queue to control the sequence of each level by offer and poll
        Queue<TreeNode> queue = new LinkedList<>();
        //edge case, don't forget
        if (root == null) {
            return res;
        }
        //first, we offer the root to the queue
        queue.offer(root);
        //then we enter the while loop
        while (!queue.isEmpty()) {
            //get the size of each level
            int n = queue.size();
            //create an arraylist to store each level
            List<Integer> temp = new ArrayList<>();
            //enter the for loop to get each value 
            for (int i = 0; i < n; i++) {
                //poll each treenode and add them into the temp
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                //after that, get the left and right treenodes of it.
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right!= null) {
                    queue.offer(cur.right);
                }
            }
            //add the level into the list
            res.add(temp);
        }
        return res;
    }
}