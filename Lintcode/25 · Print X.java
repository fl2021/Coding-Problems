public class Solution {
/**
* @param n: An integer.
* @return: A string list.
*n个字符串，每个字符串有n个字符，需要2次循环:第1次循环，i,i<=n;第2次循环,j,j<=n;
其中X的位置，有：j=i; j=n-i+1;
*/
public List<String> printX(int n) {
// write your code here.
  List<String> list = new ArrayList<String>();
    for (int i = 1 ; i <= n ; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 1 ; j <=n ; j++) {
            if (j == i || j == n - i + 1 ) {
                sb.append( "X" );
                } else {
                      sb.append(" ");
                    }
                }
        String s = sb.toString();
        list.add(s);
      }
      return list;
    }
}