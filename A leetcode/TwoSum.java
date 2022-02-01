class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            
            int temp = nums[i];
            if(hashmap.containsKey(temp)) {
                return new int[] {hashmap.get(temp), i};
            }
            else
                hashmap.put(target-temp,i);
        }
        return new int[] {};
    }
}
//Time Complexity : O(n)
//Space Complexitiy: O(n)