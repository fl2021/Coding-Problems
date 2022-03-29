class TwoSum {
    public List<Integer> nums;
    public TwoSum() {
        nums = new ArrayList<Integer>(); 
    }
    
    public void add(int number) {
        nums.add(number);
        int index = nums.size() - 1;
        while (index > 0 && nums.get(index - 1) > nums.get(index)) {
            swap(nums,index);
            index--;
        }
        
    }
    
    private void swap(List<Integer> nums, int index) {
        int temp = nums.get(index);
        nums.set(index, nums.get(index - 1));
        nums.set(index - 1,temp);
    }
    
    public boolean find(int value) {
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) == value) {
                return true;
            } else if (nums.get(i) + nums.get(j) > value) {
                j--;
            } else{
                i++;
            }
        }
      return false;  
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */