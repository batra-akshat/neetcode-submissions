class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<vector<int>> row(9, vector<int>(9));
        vector<vector<int>> col(9, vector<int>(9));
        vector<vector<vector<int>>> subgrid(3, 
        vector<vector<int>> (3, vector<int>(9)));
        for(int i= 0; i< 9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    if(row[i][num] > 0) {
                        return false;
                    }
                    if(col[j][num] > 0) {
                        return false;
                    }
                    if(subgrid[i/3][j/3][num] > 0) {
                        return false;
                    }
                    row[i][num]++;
                    col[j][num]++;
                    subgrid[i/3][j/3][num]++;
                }
            }
        }
        return true;
    }
};
