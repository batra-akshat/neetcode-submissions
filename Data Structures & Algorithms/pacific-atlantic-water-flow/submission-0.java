
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        // Track which cells can reach each ocean
        boolean[][] canReachPacific = new boolean[n][m];
        boolean[][] canReachAtlantic = new boolean[n][m];
        
        // DFS from Pacific-adjacent cells (top row and left column)
        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, canReachPacific); // Left column
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, canReachPacific); // Top row
        }
        
        // DFS from Atlantic-adjacent cells (bottom row and right column)
        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, heights, canReachAtlantic); // Right column
        }
        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, heights, canReachAtlantic); // Bottom row
        }
        
        // Find cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int i, int j, int[][] heights, boolean[][] canReach) {
        int n = heights.length;
        int m = heights[0].length;
        
        // Mark this cell as reachable
        canReach[i][j] = true;
        
        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            
            // Check bounds and if cell is not yet visited
            // Move to cells with higher or equal height (reverse of water flow)
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && 
                !canReach[newI][newJ] && heights[newI][newJ] >= heights[i][j]) {
                dfs(newI, newJ, heights, canReach);
            }
        }
    }
}

