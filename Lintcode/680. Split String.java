public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        }
        List<String> temp = new ArrayList<>();
        dfs(s, 0, temp, results);
        return results;
    }

    private void dfs(String s, int index, List<String> temp,
                    List<List<String>> results) {
        if (index == s.length()) {
            results.add(new ArrayList<>(temp));
            return;
        }                
        //split one Character
        String str = s.substring(index, index + 1);
        temp.add(str);
        dfs(s, index + 1, temp, results);
        temp.remove(temp.size() - 1);

        //splite two Characters
        if (index <= s.length() - 2) {
            str = s.substring(index, index + 2);
            temp.add(str);
            dfs(s, index + 2, temp, results);
            temp.remove(temp.size() - 1);
        }       
    }
}