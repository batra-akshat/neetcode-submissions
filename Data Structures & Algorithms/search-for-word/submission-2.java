class Solution {
    boolean[][] vis;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, word, board, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, String word, char[][] board, int startIdx) {
        int n = board.length;
        int m = board[0].length;
        if (startIdx == word.length()) {
            return true;
        }
        if(!isValid(i,j,n,m) || vis[i][j] == true) {
            return false;
        }
        if (word.charAt(startIdx) != board[i][j]) {
            return false;
        }
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int u = i + dir[0];
            int v = j + dir[1];
            if (dfs(u, v, word, board, startIdx + 1)) {
                return true;
            }
        }
        vis[i][j] = false;
        return false;
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
