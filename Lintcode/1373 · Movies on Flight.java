public class Solution {
    /**
     * @param arr: An integer array represents durations of movies
     * @param k: An integer represents the duration of the flight
     * @return: the pair of movies index with the longest total duration
     */
    public int[] FlightDetails(int[] arr, int k) {
        // write your code here
        //存一下每个数及其下标{nums: i}
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
          map.put(arr[i], i);
        }

        Arrays.sort(arr);
        int[] result = new int[2];

        int left = 0, right = arr.length - 1;
        while (left < right) {
           if (arr[left] + arr[right] > k - 30) {
             right--;
           } else {
              if (arr[left] + arr[right] > result[0] + result[1]) {
                  result[0] = arr[left];
                  result[1] = arr[right];
              }
              left++;
           }
        }
        //找下标
        result[0] = map.get(result[0]);
        result[1] = map.get(result[1]);

        //如果答案顺序相反，则交换
        if (result[0] > result[1]) {
          int temp = result[0];
          result[0] = result[1];
          result[1] = temp;
        }
        return result;
    }
}