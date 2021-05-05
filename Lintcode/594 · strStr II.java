public class Solution {
  private static final Integer BASE = 100007;
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int strStr2(String source, String target) {
        // write your code here
        if (source == null || target == null) {
          return -1;
        }

        int m = target.length();
        if (m == 0) {
            return 0;
        }

        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        //先计算一下target的hash值
        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }
        //当source code 加上右边一个character，就要减掉左边的一个character
        int sourceCode = 0;
        for (int i = 0; i < source.length(); i++) {
            sourceCode = (sourceCode * 31 + source.charAt(i)) % BASE;
            if (i <= m - 1) {
              continue;
          }

          sourceCode = (sourceCode - power * source.charAt(i - m)) % BASE;
          if (sourceCode < 0) {
            sourceCode += BASE;
          }
          if (sourceCode == targetCode) {
            return i - m + 1;
          }

        }
        return -1;
    }
}