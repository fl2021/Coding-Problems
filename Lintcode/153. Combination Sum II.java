public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            dfs(candidates, target - candidates[i], i + 1, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}