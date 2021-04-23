public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
          map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int countA = 0; 
        int countB = 0; 
        for (int n : map.keySet()) {
          int another = target - n;
          if (another == n && map.get(n) >= 2) {
            countA++;
          }
          if (another != n && map.containsKey(another)) {
            countB++;
          }
        }
        return countA + countB / 2;
    }
}