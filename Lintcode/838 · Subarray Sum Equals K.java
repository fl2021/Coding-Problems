public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsK(int[] nums, int k) {
        // Time O(n)  Space O(n)
        int count = 0;
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
          prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
          if (map.containsKey(prefixSum[i] - k)) {
            count += map.get(prefixSum[i] - k);
          }
          map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return count;
    }
}

//prefixsum[j] - prefixsum[i] = k
