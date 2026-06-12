class Solution {
    public char[][] rotateTheBox(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        char[][] op = new char[c][r];
        for (int i = 0; i < c; i++){
            for (int j = 0; j < r; j++){
                op[i][j] = '.';
            }
        }
        for (int i = 0; i < r; i++) {
            int p = c-1;
            for (int j = c-1; j >= 0; j--) {
                if (grid[i][j] == '*') {
                    op[j][r-1-i] = '*';
                    p = j-1;
                }
                else if (grid[i][j] == '#') op[p--][r-1-i] = '#';
            }
        }

        return op;
    }
}