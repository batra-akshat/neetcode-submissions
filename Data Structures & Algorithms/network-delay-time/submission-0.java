public class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.second = second;
        this.first = first;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

}
class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        // should be one index based convert to one based
        List<List<Pair>> adj = new ArrayList<>(n);
        for (int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int dis = time[2];
            u--;
            v--;
            adj.get(u).add(new Pair(v, dis));
        }
        int[] dis = new int[n];
        boolean[] vis = new boolean[n];
        src--;
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        pq.offer(new Pair(src, 0));
        while (!pq.isEmpty()) {
            var top = pq.poll();
            int u = top.first;
            if (vis[u]) continue;
            vis[u] = true;
            var neighbours = adj.get(u);
            for(var neighbour : neighbours) {
                int v = neighbour.first;
                int weight = neighbour.second;
                if (!vis[v] && dis[u] + weight < dis[v]) {
                    dis[v] = dis[u] + weight;
                    pq.offer(new Pair(v, dis[v]));
                }
            }
        }
        int maxV = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(dis[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxV = Math.max(maxV, dis[i]);
        }
        return maxV;
    }
}

