class NumArray {
  public int[] prefixSum; 
    public NumArray(int[] nums) {
      prefixSum = new int[nums.length + 1];
      for (int n = 0; n < nums.length; n++) {
        prefixSum[n + 1] = prefixSum[n] + nums[n];
      }    
    }
    
    public int sumRange(int i, int j) {
     
      return prefixSum[j + 1] - prefixSum[i];

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */