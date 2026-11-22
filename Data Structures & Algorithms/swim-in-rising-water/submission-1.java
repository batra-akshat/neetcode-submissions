class Solution {
    int infinity = 1000000000;

    public int swimInWater(int[][] grid) {
        int lo = grid[0][0], hi = infinity;
        int mid = -1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (checkGrid(mid, grid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean checkGrid(int mid, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] gridcopy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gridcopy[i][j] = Math.max(0, grid[i][j] - mid);
            }
        }
        boolean[][] vis = new boolean[n][m];
        dfs(gridcopy, 0, 0, vis);
        return vis[n - 1][m - 1];
    }

    private void dfs(int[][] gridcopy, int x, int y, boolean[][] vis) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        vis[x][y] = true;
        int n = vis.length;
        int m = vis[0].length;
        for (int[] dir : dirs) {
            int u = x + dir[0];
            int v = y + dir[1];
            if (isValid(u, v, n, m) && !vis[u][v] && gridcopy[u][v] == 0) {
                dfs(gridcopy, u, v, vis);
            }
        }
    }

    private boolean isValid(int i, int j, int n, int m) {
        return !(i < 0 || j < 0 || i >= n || j >= m);
    }
}
