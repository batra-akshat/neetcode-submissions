class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(n);
        int[] inDegree = new int[n];
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        for(int i=0;i<n;i++) {
            if(inDegree[i] == 0 && vis[i] == 0) {
                // start from these courses
                dfs(i, adj, vis, inDegree);
            }
        }
        for(int i=0;i<n;i++) {
            if(inDegree[i] !=0) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int i, List<List<Integer>> adj, int[] vis, int[] inDegree) {
        vis[i]++;
        for(var course : adj.get(i)) {
            inDegree[course]--;
            if(inDegree[course] == 0 && vis[course] == 0) {
                dfs(course, adj, vis, inDegree);
            }
        }
    }

}
