class Solution {
    public void solveSudoku(char[][] board){
        solve(board);
    }
    private boolean solve(char[][] board){
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                if (board[row][col] == '.'){
                    for (char num = '1'; num <= '9'; num++){
                        if (validDigit(board, row, col, num)){
                            board[row][col] = num;
                            if (solve(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean validDigit(char[][] board, int row, int col, char num){
        for (int i = 0; i < 9; i++){
            if (board[row][i] == num || board[i][col] == num) return false;
        }
        int frow = (row / 3) * 3;
        int fcol = (col / 3) * 3;
        for (int i = frow; i < frow + 3; i++){
            for (int j = fcol; j < fcol + 3; j++){
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}