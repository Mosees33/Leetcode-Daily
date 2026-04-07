class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if(n == 2 || n == 3) return ans;

        int queens[][] = new int[n][n];
        int row[] = new int[n];
        int leftdia[] = new int[n*2-1];
        int rightdia[] = new int[n*2-1];

        solve(0, n, row, leftdia, rightdia, queens, ans);
        return ans;
    }
    public void solve(int col, int n,int row[], int leftdia[], int rightdia[], int queens[][], List<List<String>> ans){
        if(col == n){
            List<String> list = new ArrayList<>();
            for(int i = 0;i < n;i++){
                String temp = "";
                for(int j = 0;j < n;j++){
                    if(queens[i][j] == 1) temp += "Q";
                    else temp += ".";
                }
                list.add(temp);
            }
            ans.add(new ArrayList<>(list));
        }

        for(int r = 0;r < n;r++){
            if(row[r] == 0 && leftdia[n-1 + r-col] == 0 && rightdia[r+col] == 0){
                queens[r][col] = 1;
                row[r] = 1;
                leftdia[n-1 + r-col] = 1;
                rightdia[r+col] = 1;
                solve(col+1, n, row, leftdia, rightdia, queens, ans);
                queens[r][col] = 0;
                row[r] = 0;
                leftdia[n-1 + r-col] = 0;
                rightdia[r+col] = 0;
            }
        }
    }
}