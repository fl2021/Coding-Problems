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
        int left = i + 1, right = nums.length - 1;
        int target = -nums[i];
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }   
}
//O(n^2) O(1)
