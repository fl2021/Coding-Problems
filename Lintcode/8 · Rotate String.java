public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
            // write your code here
      if (str.length == 0) {
          return;p
       }

      for (int i = 0; i < offset % str.length; i++) {
            char temp = str[str.length - 1];
            for (int j = str.length - 1; j > 0; j--) {
                str[j] = str[j - 1];
            }
            str[0]= temp;
        }
        return;
    }
}