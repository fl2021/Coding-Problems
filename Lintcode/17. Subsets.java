public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }

    private void dfs(int[] nums,
                     int startIndex,
                     List<Integer> subset,
                     List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            //[1]->[1,2]
            //去寻找以【1，2】开头的所有子集
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            //
            subset.remove(subset.size() - 1);
        }
    }
}