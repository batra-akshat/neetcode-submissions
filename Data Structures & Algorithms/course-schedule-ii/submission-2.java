

class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(n);
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                // start from these courses
                if(!dfs(i, adj, vis, order)) {
                    return new int[0];
                }
            }
        }
        Collections.reverse(order);
        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int i, List<List<Integer>> adj, int[] vis, List<Integer> order) {
        if (vis[i] == 1) return false; // Cycle detected!
        if (vis[i] == 2) return true;  // Already processed
        vis[i] = 1;
        for (var course : adj.get(i)) {
            if (!dfs(course, adj, vis, order)) {
                return false;
            }
        }
        order.add(i);
        vis[i] = 2;
        return true;
    }
}

