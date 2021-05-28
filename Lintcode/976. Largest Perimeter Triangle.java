class Solution {
    public int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 2; i--) {
            if (a[i - 1] + a[i - 2] > a[i]) {
                return a[i - 1] + a[i - 2] + a[i];
            }
        }
        return 0;
    }
}