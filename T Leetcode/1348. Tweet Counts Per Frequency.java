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

class TweetCounts {
    // use treemap to record the timeframe
    private Map<String, TreeMap<Integer, Integer>> data;
    private Map<String, Integer> freqs;

    public TweetCounts() {
        data = new HashMap<>();
        freqs = new HashMap<>();
        freqs.put("minute", 60);
        freqs.put("hour", 3600);
        freqs.put("day", 3600*24);
               
    }
    
    public void recordTweet(String tweetName, int time) {
        if (!data.containsKey(tweetName)) {
            data.put(tweetName, new TreeMap<>());
        }
        TreeMap<Integer, Integer> times = data.get(tweetName);
        times.put(time, times.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int gap = freqs.get(freq);
        
        int[] res = new int[(endTime - startTime) / gap + 1];
        for (Map.Entry<Integer,Integer> entry : data.get(tweetName).subMap(startTime, endTime + 1).entrySet()) {
            res[(entry.getKey() - startTime) / gap] += entry.getValue();
        }
        List<Integer> returnRes = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            returnRes.add(res[i]);
        }
        
        return returnRes;
        
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */

//O(logn) by using TreeMap O(n)