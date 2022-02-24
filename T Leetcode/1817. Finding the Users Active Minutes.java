class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // logs[i] = [IDi, timei]
        int[] res = new int[k];
        //record the ID with the times of the different minites they used(this can use set to exclude the             //duplicated minute)
        //use hashmap to record the ID as the key with the minute as the value
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int size = logs.length;
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(logs[i][0])) {
                map.put(logs[i][0], new HashSet<Integer>());
                map.get(logs[i][0]).add(logs[i][1]);
            } else {
                map.get(logs[i][0]).add(logs[i][1]);
            }
        }
        //<0,(2,5)> <1,(2,3)>
        for (int key: map.keySet()) {
            res[map.get(key).size() - 1]++;
        }
        return res;
    }
}