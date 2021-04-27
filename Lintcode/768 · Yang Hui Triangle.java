public class Solution {
    /**
     * @param n: a Integer
     * @return: the first n-line Yang Hui's triangle
     */
    public List<List<Integer>> calcYangHuisTriangle(int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        int i, j;
        if (n == 0) {
            return res;
        }

        for (i = 0; i < n; i++) {
          List<Integer> t = new ArrayList<Integer>();
          t.add(1);
          for (j = 1; j < i; j++) {
              t.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
          }

          if (i > 0) {
            t.add(1);
          }

          res.add(t);
        }

        return res;
    }
}