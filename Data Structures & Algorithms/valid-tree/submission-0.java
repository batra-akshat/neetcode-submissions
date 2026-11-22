class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);
        int[] vis = new int[n];
        int[] par = new int[n];
        Arrays.fill(par, -1);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[1]).add(edge[0]);
            adj.get(edge[0]).add(edge[1]);
        }
        var ans = isGraphAcyclic(0, adj, vis, par, -1 );
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                // start from these courses
                return false;
            }
        }
        return ans;
    }

    private boolean isGraphAcyclic(int i, List<List<Integer>> adj, int[] vis, int[] par, int prev) {
        if(vis[i] == 1) {
            return false;
        }
        vis[i] = 1;
        par[i] = prev;
        for (var vertex : adj.get(i)) {
            if(vertex != par[i]) {
                if(!isGraphAcyclic(vertex, adj, vis, par, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}