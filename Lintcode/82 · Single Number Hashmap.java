public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        //use hashmap to save the interger, appear times, return the one only appear once.
        //corner case
        if (A == null || A.length == 0) {
          return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int count = map.getOrDefault(A[i], 0);
            map.put(A[i], count + 1);
          }
        
        for (int i = 0; i < A.length; i++) {
          if (map.get(A[i]) == 1) {
            return A[i];
          }
        }
        return -1;
    
    }
}