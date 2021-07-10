public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
          return 0;
        }
        if (k == 0) {
          return -1;
        }

        int start = 0, end = Integer.MAX_VALUE;

        while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          if (getNumberOfCopiers(pages, mid) <= k) {
            end = mid;
          } else {
            start = mid;
          }
        }
        if (getNumberOfCopiers(pages, start) <= k) {
          return start;
        }
        return end;
    }
    private int getNumberOfCopiers(int[] pages, int limit) {
      int copiers = 0;
      int lastCopier = limit;

      for (int page : pages) {
        if (page > limit) {
          return Integer.MAX_VALUE;
        }
        if (lastCopier + page > limit) {
          copiers++;
          lastCopier = 0;
        }
        lastCopier += page;
      }
      return copiers;
    }
}