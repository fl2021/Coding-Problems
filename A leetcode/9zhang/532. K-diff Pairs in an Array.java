class Solution {
    public int findPairs(int[] nums, int d) {
        // the most tricky thing is when d = 0,there will be multiple situations
        
        HashMap<Integer,Integer> map = new HashMap<>();
        //num,times
        for (int num : nums) {  
        //加入hashmap
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

       int count = 0;
        if (d == 0) {
            for (int num : map.values()) {
                if (num > 1) {
                    count++;
                }
            }
        } else {
            for (int num : map.keySet()) {
                if (map.containsKey(num + d)) {
                    count++;
                }          
            }
        }
    return count;
    }
}