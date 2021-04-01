public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        //建立一个最小堆，打算在这个堆里面存k个元素，poll（
        if (nums == null || nums.length == 0) {
          return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
          minHeap.offer(num);
          if (minHeap.size() > k) {
            minHeap.poll();

          }
        }
        return minHeap.poll();
        //minHeap = {2,3,4,8,9}
    }
}

//[9,3,2,4,8]
//for () {

//}
//minHeap = {2,3,4,8,9}
//if (minHeap.size() k) {

//}
//minHeap = [4, 8, 9]
//poll ->4