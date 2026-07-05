class Solution {
    private int n, m;

    private void dfs(int i, int j, char[][] board)
    {
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]!='O')
        {
            return;
        }

        board[i][j]='B';

        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
    }
    public void solve(char[][] board) {

       n=board.length;
       m=board[0].length;

       for(int i=0; i<m; i++)
       {
        if(board[0][i]=='O')
        {
            dfs(0, i, board);
        }

        if(board[n-1][i]=='O')
        {
            dfs(n-1, i, board);
        }
       }

       for(int i=0; i<n; i++)
       {
        if(board[i][0]=='O')
        {
            dfs(i, 0, board);
        }

        if(board[i][m-1]=='O')
        {
            dfs(i, m-1, board);
        }
       }

       for(int i=0; i<n; i++)
       {
        for(int j=0; j<m; j++)
        {
            if(board[i][j]=='B')
            {
                board[i][j]='O';
            }
            else if(board[i][j]=='O')
            {
                board[i][j]='X';
            }
        }
       }

    }
}