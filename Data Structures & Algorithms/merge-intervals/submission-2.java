class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                int[] prev = mergedIntervals.get(mergedIntervals.size() - 1);
                prev[1] =  Math.max(intervals[i][1], prev[1]);
            } else {
                mergedIntervals.add(intervals[i]);
            }
        }
        return mergedIntervals.toArray(new int[0][0]);
    }
}
