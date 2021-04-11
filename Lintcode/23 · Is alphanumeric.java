public class Solution {
    /**
     * @param c: A character.
     * @return: The character is alphanumeric or not.
     */
    public boolean isAlphanumeric(char c) {
        // write your code here
      if (Character.isLetterOrDigit(c)) {
        return true;
      }
      return false;
    }
}