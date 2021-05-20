class Solution {
    public int arrangeCoins(int n) {
        int low = 0;
        int high = n;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            long cost = ((mid + 1) * mid) / 2;
            if (cost == n) {
                return (int)mid;
            } else if (cost > n) {
                high = (int)mid - 1;
            } else{
                low = (int)mid + 1;
            }
        }
        return high;
    }
}