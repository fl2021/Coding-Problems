public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> res = new ArrayList<>();
        long product = 1;
        res.add(product);
        
        int len = nums.size();
        for (int i = 1; i < len; i++) {
            product *= nums.get(i - 1);
            res.add(product);
        }
        
        product = 1;
        for (int i = len - 2; i >= 0; i--) {
            product *= nums.get(i + 1);
            res.set(i, res.get(i) * product);
        }
        return res;

    }
}