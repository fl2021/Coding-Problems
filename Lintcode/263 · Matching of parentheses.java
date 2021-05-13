public class Solution {
    /**
     * @param string: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean matchParentheses(String string) {
        // write your code here
        if (string == null || string.length() == 0) {
          return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : string.toCharArray()) {
          if (c == '(') {
            stack.push(c);
          } else if (c == ')') {
            if (stack.isEmpty() || stack.pop() != '(') {
              return false;
            }
          }
        }
        return stack.isEmpty();
    }
}