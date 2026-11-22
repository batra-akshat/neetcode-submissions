class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        NavigableSet<int[]> sortedIntervals = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        sortedIntervals.addAll(Arrays.asList(intervals));
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        for(int i = 0; i <m;i++) {
            var headSetReverseIterator = sortedIntervals.headSet(new int[]{queries[i], Integer.MAX_VALUE}, true).descendingIterator();
            int res = Integer.MAX_VALUE;
            while (headSetReverseIterator.hasNext()) {
                int[] interval = headSetReverseIterator.next();
                if(queries[i] >= interval[0] && queries[i] <= interval[1]) {
                    res = Math.min(res, interval[1] - interval[0] + 1);
                }
            }
            if(res!=Integer.MAX_VALUE) {
            ans[i] = res;
            }
        }
        return ans;
    }
}