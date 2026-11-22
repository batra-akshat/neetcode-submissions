class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (var flight : flights) {
            adj.get(flight[0]).add(List.of(flight[1], flight[2]));
        }
        int dis[][] = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], 100000000);
        }
        Queue<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{src, 0});
        dis[src][0] = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            int step = top[1];
            if(step > k) {
                continue;
            }
            for(var neighbour :adj.get(u)) {
                int v = neighbour.get(0);
                int weight = neighbour.get(1);
                if(dis[v][step+1] > dis[u][step] + weight) {
                    pq.add(new int[] {v, step+1});
                    dis[v][step+1] = dis[u][step] + weight;
                }
            }
        }
        int ans = 100000000;
        for(int i=0;i<=k+1;i++) {
            ans = Math.min(ans, dis[dst][i]);
        }
        return ans == 100000000 ? -1 : ans;
    }
}