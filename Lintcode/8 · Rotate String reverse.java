public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
          return;
        }
        if (offset == 0) {
          return;
        }
        int rotate = offset % str.length;
        reverse(0, str.length - rotate - 1, str);
        reverse(str.length - rotate, str.length - 1, str);
        reverse(0, str.length - 1, str);
    }
    private void reverse(int start, int end, char[] str) {
      while (start < end) {
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;
        start++;
        end--;
      }
    }
}