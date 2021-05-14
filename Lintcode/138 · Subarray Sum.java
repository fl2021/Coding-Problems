public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
          sum += nums[i];
          if (map.containsKey(sum)) {
            results.add(map.get(sum));
            results.add(i);
            return results;
          } else {
            map.put(sum, i + 1);
          }
        }
        return results;

    }
}