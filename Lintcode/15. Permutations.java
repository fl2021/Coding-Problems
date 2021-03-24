public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, temp, results, visited);
        return results;
    }

    private void dfs(int[] nums,
                  List<Integer> temp, 
                  List<List<Integer>> results,
                  boolean[]visited) {
        // base case              
        if (temp.size() == nums.length) {
            results.add(new ArrayList<Integer>(temp));
            return;
        } 

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums, temp, results, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }             
    }
}