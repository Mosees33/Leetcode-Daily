class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int vis[][] = new int[n][m];

        for(int i = 0;i < m;i++) if(board[0][i] == 'O' && vis[0][i] == 0) dfs(0, i, board, vis);
        
        for(int j = 0;j < n;j++) if(board[j][0] == 'O' && vis[j][0] == 0) dfs(j, 0, board, vis);

        for(int i = 0;i < m;i++) if(board[n-1][i] == 'O' && vis[n-1][i] == 0) dfs(n-1, i, board, vis);

        for(int j = 0;j < n;j++) if(board[j][m-1] == 'O' && vis[j][m-1] == 0) dfs(j, m-1, board, vis);

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == 'O'){
                    if(vis[i][j] == 0) board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, char board[][], int vis[][]){
        vis[i][j] = 1;
        int n = board.length;
        int m = board[0].length;

        if(i-1 >= 0) if(board[i-1][j] == 'O' && vis[i-1][j] == 0) dfs(i-1, j, board, vis);
        if(j-1 >= 0) if(board[i][j-1] == 'O'&& vis[i][j-1] == 0) dfs(i, j-1, board, vis);
        if(i+1 < n) if(board[i+1][j] == 'O' && vis[i+1][j] == 0) dfs(i+1, j, board, vis);
        if(j+1 < m) if(board[i][j+1] == 'O' && vis[i][j+1] == 0) dfs(i, j+1, board, vis);
    }
}