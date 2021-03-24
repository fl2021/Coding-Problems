public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (str == null) {
            return results;
        }

        // string is immutable
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        String temp = new String();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, temp, results, visited);
        return results;
    }

    private void dfs(char[] arr, String temp, List<String> results, boolean[]visited) {
        if (temp.length() == arr.length) {
            results.add(new String(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            if (i > 0 && arr[i] == arr[i-1] && !visited[i-1]) {
                continue;
            }

            temp += arr[i];
            visited[i] = true;
            dfs(arr, temp, results, visited);
            temp = temp.substring(0, temp.length() - 1);
            visited[i] = false;
        }
    }
}
