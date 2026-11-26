class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][][] subgrid = new int[3][3][10];
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.') {
                    int val = board[i][j]-'0';
                    if(rows[i][val] >0 || cols[j][val] > 0 || subgrid[i/3][j/3][val] > 0){
                        return false;
                    }
                    rows[i][val]++;
                    cols[j][val]++;
                    subgrid[i/3][j/3][val]++;
                }
            }
        }
        return true;
    }
}
