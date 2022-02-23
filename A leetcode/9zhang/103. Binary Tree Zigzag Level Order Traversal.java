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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        //edge case
        if (root == null) {
            return lists;
        }
        
        //BFS 要用到queue
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        //正反向标志
        boolean isLeftToRight = true;
        //BFS开始模版
        q.offer(root);
        while (!q.isEmpty()) {
            //逐层变层：记录当前queue的size，然后遍历size个元素
            int size = q.size();
            //存放当前层元素的list
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                //从queue中取出一个点
                TreeNode node = q.poll();
                //加入当前层的list；
                list.add(node.val);
                //如果左右孩子不为空，入队
                //可不可以不在这里检查null，直接入队呢？
                //可以，但是需要
                //1.加入一个logic，如果null，continue；
                //2.如果list最后为空，不要记入lists
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                
            }
            //如果从右至左，需要翻转
            if(!isLeftToRight) {
                Collections.reverse(list);
            }
            //把当前层加入结果集
            lists.add(list);
            //方向反转
            isLeftToRight = !isLeftToRight;
        }
        return lists;
        
    }
}