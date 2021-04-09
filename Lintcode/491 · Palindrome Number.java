    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        return num == Reverse(num);
    }
    public int Reverse(int num) {
        int reverse = 0;
        while (num != 0) {
          reverse = reverse * 10 + num % 10;
          num = num / 10;
        }
        return reverse;
    }    
}
