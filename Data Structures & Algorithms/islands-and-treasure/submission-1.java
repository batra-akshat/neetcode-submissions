class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            var front = q.poll();
            int i = front.x;
            int j = front.y;
            if (isValid(i + 1, j, n, m, vis, grid)) {
                q.add(new Pair(i + 1, j));
                vis[i + 1][j] = true;
                grid[i + 1][j] = grid[i][j] + 1;
            }
            if (isValid(i, j + 1, n, m, vis, grid)) {
                q.add(new Pair(i, j + 1));
                vis[i][j + 1] = true;
                grid[i][j + 1] = grid[i][j] + 1;
            }
            if (isValid(i - 1, j, n, m, vis, grid)) {
                q.add(new Pair(i - 1, j));
                vis[i - 1][j] = true;
                grid[i - 1][j] = grid[i][j] + 1;
            }
            if (isValid(i, j - 1, n, m, vis, grid)) {
                q.add(new Pair(i, j - 1));
                vis[i][j - 1] = true;
                grid[i][j - 1] = grid[i][j] + 1;
            }
        }
    }

    private boolean isValid(int i, int j, int n, int m, boolean[][] vis, int[][] grid) {
        return !(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == -1);
    }
}
