public class Solution {
    /**
     * @param str: the pattern 
     * @return: the minimum number
     */
    public String formMinimumNumber(String str) {
        // Write your code here.
        if (str == null || str.length() == 0) {
          return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() + 1; i++) {
          sb.append(i + 1);
        }

        for (int i = 0; i < str.length(); i++) {
          char c = str.charAt(i);
          if (c == 'D') {
            int j = i;
            while (j < str.length() && str.charAt(j) == 'D') {
              j++;
            }
            swap(sb, i, j);
            i = j;
          }         
      }
      return sb.toString();  
    }
        
    private void swap(StringBuilder sb, int i, int j) {
        while (i < j) {
          char temp = sb.charAt(i);
          sb.setCharAt(i, sb.charAt(j));
          sb.setCharAt(j, temp);
          i++;
          j--;
        }
    }
}