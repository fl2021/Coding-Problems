class Solution {
    public int subarraySum(int[] nums, int k) {
        //subarry Sum-prefixSum will simply this
        //HashMap<Integer(prefixSum), Integer(index)>
        HashMap <Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        //这里最关键的是这个初始值的输入（0，1），之前输入了（0，0）或者（0，-1）都错
        //内在逻辑在于，当prefixsum - k = 0的时候说明prefixsum=k，此时就加value               //（+1）
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0) + 1);    
        }
        return count;    
    }
}
