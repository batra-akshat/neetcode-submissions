class Solution {
    List<List<String>> ans;
    boolean[] rowUsed;
    boolean[] colUsed;
    Map<Integer, Boolean> mainDiagOccupied;
    Map<Integer, Boolean> antiDiagOccupied;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        rowUsed = new boolean[n];
        colUsed = new boolean[n];
        antiDiagOccupied = new HashMap<>();
        mainDiagOccupied = new HashMap<>();
        backTrack(n, new ArrayList<>(), 0, 0);
        return ans;
    }

    private void backTrack(int n, ArrayList<String> res, int row, int numberOfQueens) {
        if (numberOfQueens == n) {
            ans.add(new ArrayList<>(res));
            return;
        }
        if (row >= n) {
            return;
        }
        for (int col = 0; col < n; col++) {
            if (unused(row, col)) {
                rowUsed[row] = true;
                colUsed[col] = true;
                mainDiagOccupied.put(row + col, true);
                antiDiagOccupied.put(row - col, true);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == col) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                res.add(sb.toString());
                backTrack(n, res, row + 1, numberOfQueens + 1);
                rowUsed[row] = false;
                colUsed[col] = false;
                mainDiagOccupied.put(row + col, false);
                antiDiagOccupied.put(row - col, false);
                res.remove(res.size() - 1);
            }
        }
    }

    private boolean unused(int i, int j) {
        return !rowUsed[i] && !colUsed[j] &&
                !mainDiagOccupied.getOrDefault(i + j, false) &&
                !antiDiagOccupied.getOrDefault(i - j, false);
    }
}
