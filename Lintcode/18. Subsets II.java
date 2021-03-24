public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, results);
        return results;
    }

    private void dfs(int[] nums, 
                    int startIndex,
                    List<Integer> temp, 
                    List<List<Integer>> results){

        results.add(new ArrayList<Integer> (temp));

        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, i + 1, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}