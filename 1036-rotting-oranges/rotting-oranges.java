class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        if(n == 0) return 0;
        int fresh = 0;
        int minutes = 0;

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        if(fresh == 0) return 0;

        int dir[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty()){
            boolean rotten = false;
            int size = q.size();

            for(int i = 0;i < size;i++){
                int temp[] = q.poll();
                int row = temp[0];
                int col = temp[1];

                for(int t[] : dir){
                    int nr = row + t[0];
                    int nc = col + t[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                        rotten = true;
                        q.add(new int[]{nr, nc});
                        fresh--;
                        grid[nr][nc] = 2;
                    }
                } 
            }

            if(rotten) minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}