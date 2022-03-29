class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSum (nums, i, result);   
        }
        return result;  
    }
    public void twoSum(int[] nums, int i, List<List<Integer>> result) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length;j++) {
            int sum = - (nums[i] + nums[j]);
            if (seen.contains(sum)) {
                result.add(Arrays.asList(nums[i], nums[j], sum));
                while (j + 1 < nums.length && nums[j] == nums[j+1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }   
}
//O(n^2) O(n)