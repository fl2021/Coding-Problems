//Hence this question requires a binary search to find number of tweets in a given interval, one could easily implement an array and have binary search approach to insert new tweets in the array. Implementing binary tree would cut the search and insert from O(n) to O(logn).


//
//
class TweetCounts {
    
    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        
        private TreeNode(int data) {
            val = data;
            left = null;
            right = null;
        }
    }
    
    private Map<String, TreeNode> map;

    public TweetCounts() {
        map = new HashMap<>();
        // use the hashmap to record the tweetcounts
        //<key: tweet, value:timeline(root,has timeline in a tree format)
        
        
    }
    
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        else if (root.val <= val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }
    
    public void recordTweet(String tweetName, int time) {
        TreeNode root = map.get(tweetName);
        root = insert(root, time);
        map.put(tweetName, root);
        
    }
    
    private int traverse(TreeNode root, int l, int r) {
        if (root == null || l >= r) {
            return 0;
        }
        
        if (root.val <= l) {
            int add = root.val == l ? 1 : 0;
            return add + traverse(root.right, l, r);
        }
    
        if (root.val >= r) {
            return traverse(root.left, l, r);
        }
        return 1 + traverse(root.left, l, r) + traverse(root.right, l ,r);
    }
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int d = 0;
        TreeNode root = map.get(tweetName);
        List<Integer> res = new ArrayList<>();
        if (freq.equals("minute")) {
            d = 60;
        } else if (freq.equals("hour")) {
            d = 3600;
        } else {
            d = 86400;
        }
        while (startTime + d <= endTime) {
            int count = traverse(root, startTime, startTime + d);
            startTime = startTime + d;
            res.add(count);
        }
        if (startTime <= endTime) {
            int count = traverse(root, startTime, endTime + 1);
            res.add(count);
            startTime = endTime + 1;
        }
        return res;
        
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
/**
*
*insert() is O(logn), hence, recordTweet is O(logn) as well. The worst-case scenario for getTweetCountsPerFrequency() is O(n), since one 
* would visit all the nodes in the tree only once.
*
*/
