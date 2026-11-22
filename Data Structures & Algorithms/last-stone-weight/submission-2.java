class Solution {
    Comparator<Integer> greaterIntComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        Queue<Integer> pq = new PriorityQueue<>(greaterIntComparator);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int top = pq.poll();
            int secondTop = pq.poll();
            if(top > secondTop) {
                pq.add(top - secondTop);
            }
        }
        int ans = pq.isEmpty()? 0 : pq.peek();
        return ans;
    }
}
