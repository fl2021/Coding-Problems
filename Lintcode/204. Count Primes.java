class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        //false means prime 初始化时都是false，之后发现是合数改成true
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j < n; j+=i) {
                    //j means not prime;合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}