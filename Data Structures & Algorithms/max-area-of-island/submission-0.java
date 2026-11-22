class Solution {
    private int ans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]vis = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i,j,vis,grid));
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, boolean[][] vis, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || grid[i][j] == 0) {
            return 0;
        }
        vis[i][j] = true;
        return 1 + dfs(i+1,j,vis,grid) + dfs(i,j+1,vis,grid) + dfs(i-1,j,vis,grid) + dfs(i,j-1,vis,grid);
    }
}

