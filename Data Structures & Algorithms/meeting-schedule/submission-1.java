/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if(n == 0) {
            return true;
        }
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals.get(0));
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (intervals.get(i).start < mergedIntervals.get(mergedIntervals.size() - 1).end) {
                var prev = mergedIntervals.get(mergedIntervals.size() - 1);
                prev.end =  Math.min(intervals.get(i).end, prev.end);
                ans++;
            } else {
                mergedIntervals.add(intervals.get(i));
            }
        }
        return ans ==0;
    }
}
