class Solution {
    public int maxProductPath(int[][] grid) {
        int MOD = 1000000007;
        int n = grid.length;
        int m = grid[0].length;
        long maxDP[][] = new long[n][m];
        long minDP[][] = new long[n][m];

        maxDP[n-1][m-1] = minDP[n-1][m-1] = grid[n-1][m-1];

        for(int i = m-2;i >= 0;i--){
            maxDP[n-1][i] = minDP[n-1][i] = maxDP[n-1][i+1] * grid[n-1][i];
        }

        for(int i = n-2;i >= 0;i--){
            maxDP[i][m-1] = minDP[i][m-1] = maxDP[i+1][m-1] * grid[i][m-1];
        }

        for(int i = n-2;i >= 0;i--){
            for(int j = m-2;j >= 0;j--){
                long a = maxDP[i+1][j] * grid[i][j];
                long b = maxDP[i][j+1] * grid[i][j];
                long c = minDP[i+1][j] * grid[i][j];
                long d = minDP[i][j+1] * grid[i][j];

                maxDP[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minDP[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        return maxDP[0][0] < 0 ? -1 : (int)(maxDP[0][0] % MOD);
    }
}