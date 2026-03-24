class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long pref[][] = new long[n][m];
        long suff = 1;

        long prod = 1;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                pref[i][j] = prod;
                prod = (prod * grid[i][j]) % 12345;
            }
        }

        for(int i = n-1;i >= 0;i--){
            for(int j = m-1;j >= 0;j--){
                long temp = (pref[i][j] * suff) % 12345L;
                suff = (suff * grid[i][j]) % 12345;
                grid[i][j] = (int)temp;
            }
        }
        return grid;
    }
}