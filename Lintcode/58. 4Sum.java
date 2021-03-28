public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return results;
        }
        
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }    
                int left = j + 1, right = numbers.length - 1;
                twoSum(numbers, i, j, left, right, target, results);
            }
        }
        return results;
        
    }
    
    private void twoSum(int[] numbers, int firstIndex, int secondIndex, int left, int right, int target, List<List<Integer>> results) {
        while(left < right) {
            int sum = numbers[firstIndex] + numbers[secondIndex] + numbers[left] + numbers[right];
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(numbers[firstIndex]);
                temp.add(numbers[secondIndex]);
                temp.add(numbers[left]);
                temp.add(numbers[right]);
                results.add(temp);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
                
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}