class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int len = m*n;
        k = k % len;
        ArrayList<List<Integer>> list = new ArrayList<>();
        
        int arr[] = new int[len];
        int e = 0;
        for(int i[] : grid){
            for(int j : i){
                arr[e++] = j;
            }
        }

        int temp = len - k;
        for(int i = 0;i < n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0;j < m;j++){
                row.add(arr[temp % len]);
                temp++;
            }
            list.add(row);
        }
        return list;
    }
}