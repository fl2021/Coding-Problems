public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, temp, results, visited);
        return results;
    }

    private void dfs(int[] nums, 
                    List<Integer> temp,
                    List<List<Integer>> results, 
                    boolean[] visited ) {
            if (temp.size() == nums.length) {
            results.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums, temp, results, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
};