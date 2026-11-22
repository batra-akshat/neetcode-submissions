class Pair {
    int from;
    int to;

    Pair(int from, int to) {
        this.to = to;
        this.from = from;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return from == pair.from && to == pair.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

}

class Solution {
    private int cycleStart = -1;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>(n + 1);
        int[] vis = new int[n + 1];
        int[] par = new int[n+1];
        Arrays.fill(par, -1);
        HashMap<Pair, Integer> mp = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            var edge = edges[i];
            adj.get(edge[1]).add(edge[0]);
            adj.get(edge[0]).add(edge[1]);
            mp.put(new Pair(edge[0], edge[1]), i);
            mp.put(new Pair(edge[1], edge[0]), i);
        }
        List<Integer> cycle = new ArrayList<>();
        hasCycle(1, adj, vis, cycle, -1);
        int idxForEdgeToRemove = -1;
        int m = cycle.size();
        for (int i = 0; i < m; i++) {
            int idx = mp.getOrDefault(new Pair(cycle.get(i), cycle.get((i+1)%m)), -1);
            if(idx > idxForEdgeToRemove) {
                idxForEdgeToRemove = idx;
            }
        }
        return edges[idxForEdgeToRemove];
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] vis, List<Integer> cycle, int par) {
        if (vis[node] == 1) {
            cycleStart = node;
            return true;
        }
        vis[node] = 1;
        for (int nei : adj.get(node)) {
            if (nei == par) continue;
            if (hasCycle(nei, adj,vis, cycle, node)) {
                if (cycleStart != -1) cycle.add(node);
                if (node == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}