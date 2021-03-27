public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, target, 0, temp, results);
        return results;
    }

    private void dfs(int[] candidates, int target, int startIndex, 
                    List<Integer> temp, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(temp));
            return;
        }  

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // cut leaves
            if (target < candidates[i]) {
                break;
            }
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}