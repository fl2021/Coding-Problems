public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b 
     */
    public int aplusb(int a, int b) {
        // write your code here
    


int s = a ^ b; 
int t = a & b; 
while (t != 0) {
int tempA = s;
int tempB = t << 1;
s = tempA ^ tempB;
t = tempA & tempB;
}

return s;
}}