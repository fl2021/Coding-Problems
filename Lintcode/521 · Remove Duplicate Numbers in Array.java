    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
          return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] != nums[count]) {
              nums[++count] = nums[i];
          }
        }

        return count + 1;
    }
}