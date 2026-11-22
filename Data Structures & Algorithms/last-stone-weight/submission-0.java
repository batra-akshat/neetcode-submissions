class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
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
