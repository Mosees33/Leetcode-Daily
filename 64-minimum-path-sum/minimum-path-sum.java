class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans[][] = new int[n][m];
        ans[n-1][m-1] = grid[n-1][m-1];

        for(int i = m-2;i >= 0;i--){
            ans[n-1][i] = ans[n-1][i+1] + grid[n-1][i];
        }

        for(int i = n-2;i >= 0;i--){
            ans[i][m-1] = ans[i+1][m-1] + grid[i][m-1];
        }

        for(int i = n-2;i >= 0;i--){
            for(int j = m-2;j >= 0;j--){
                ans[i][j] = grid[i][j] + (Math.min(ans[i+1][j], ans[i][j+1]));
            }
        }
        return ans[0][0];
    }
}