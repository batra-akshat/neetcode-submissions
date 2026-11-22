class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        TreeSet<int[]> st = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        Collections.addAll(st, intervals);
        st.add(newInterval);

        int leftBoundary = newInterval[0];
        int rightBoundary = newInterval[1];

        // Delete elements to the left of newInterval
        Iterator<int[]> leftIterator = st.headSet(newInterval, false).descendingIterator();
        while(leftIterator.hasNext()) {
            int[] current = leftIterator.next();
            if(shouldDeleteLeft(current, newInterval)) {
                leftBoundary = Math.min(leftBoundary, current[0]); // Extend boundary
                rightBoundary = Math.max(rightBoundary, current[1]);
                leftIterator.remove();
            } else {
                break; // current becomes the left boundary reference
            }
        }

        // Delete elements to the right of newInterval
        Iterator<int[]> rightIterator = st.tailSet(newInterval, false).iterator();
        while(rightIterator.hasNext()) {
            int[] current = rightIterator.next();
            if(shouldDeleteRight(current, newInterval)) {
                rightBoundary = Math.max(rightBoundary, current[1]); // Extend boundary
                rightIterator.remove();
            } else {
                break; // current becomes the right boundary reference
            }
        }

        st.remove(newInterval);
        int[] mergeInterval = new int[] {leftBoundary, rightBoundary};
        st.add(mergeInterval);

        // Convert to array
        int[][] ans = new int[st.size()][2];
        int i = 0;
        for(int[] interval : st) {
            ans[i++] = interval;
        }
        return ans;
    }

    private boolean shouldDeleteLeft(int[] interval, int[] newInterval) {
        return interval[1] >= newInterval[0];
    }

    private boolean shouldDeleteRight(int[] interval, int[] newInterval) {
        return interval[0] <= newInterval[1];
    }
}