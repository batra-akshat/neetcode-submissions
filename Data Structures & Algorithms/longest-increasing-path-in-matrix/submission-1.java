class Solution {
    private Integer[][] dp;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        dp = new Integer[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(dfs(i, j, a), ans);
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] a) {
        int n = a.length;
        int m = a[0].length;
        if (notValid(i, j, n, m)) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int ans = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (!notValid(x, y, n, m) && a[x][y] > a[i][j]) {
                ans = Math.max(ans, 1 + dfs(x, y, a));
            }

        }
        dp[i][j] = ans;
        return dp[i][j];
    }

    private boolean notValid(int i, int j, int n, int m) {
        return (i < 0 || j < 0 || i >= n || j >= m);
    }
}