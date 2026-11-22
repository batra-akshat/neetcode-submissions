class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                int[] prev = mergedIntervals.get(mergedIntervals.size() - 1);
                prev[1] =  Math.min(intervals[i][1], prev[1]);
                ans++;
            } else {
                mergedIntervals.add(intervals[i]);
            }
        }
        return ans;
    }
}
