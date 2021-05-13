public class Solution {
    /**
     * @param n: a integer
     * @return: return a string
     */
    public String convertToTitle(int n) {
        // write your code here
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
          map.put(i, (char)('A' + i));
        }
        String result = "";
        while (n > 0) {
          n--;
          result = map.get(n % 26) + result;
          n = n / 26;
        }
        return result;
    }
}
//和第一种方法一样，先算出来的放在后面，所以result要放在后面，不然就错了
// 28 ： 27  1， b；
// 1： 0: a