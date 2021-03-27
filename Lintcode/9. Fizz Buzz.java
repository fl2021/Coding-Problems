public class Solution {
/**
* @param n: An integer
* @return: A list of strings.
*/
public List<String> fizzBuzz(int n) {
// write your code here
List<String> myList = new ArrayList<String>();
for (int i = 1; i < n + 1; i++){
String value = (i % 3 == 0 && i % 5 == 0)? "fizz buzz": (i % 3== 0)? "fizz": (i % 5 == 0)? "buzz": Integer.toString(i);
myList.add(value);
}
return myList;
}
}