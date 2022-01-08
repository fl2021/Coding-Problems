class Solution {
    public int[][] merge(int[][] intervals) {
        // arraylist for result, should change back to array later
        ArrayList<int[]> res = new ArrayList();
        //edge case
        if (intervals.length <= 1) {
            return intervals;
        }
        //sort the intervals according to the first index of each pair
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int[] in = intervals[0];
        int i = 1;
        while (i < intervals.length) {
            if (in[1] < intervals[i][0]) {
                res.add(in);
                in = intervals[i];
            } else {
                in[1] = Math.max(in[1], intervals[i][1]);
            }
            i++;
        }
        res.add(in);
        return res.toArray(new int[res.size()][]);
        
    }
}