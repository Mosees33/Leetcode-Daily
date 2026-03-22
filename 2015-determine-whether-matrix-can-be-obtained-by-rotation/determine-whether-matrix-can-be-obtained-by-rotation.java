class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        int n = mat.length;
        if(compare(mat, target, n)) return true;
        int rot = 3;
        while(rot > 0){
            mat = rotate(mat, n);
            if(compare(mat, target, n)) return true;
            rot--;
        }
        return false;

    }
    public int[][] rotate(int mat[][], int n){
        
        int temp[][] = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                temp[n-1-j][i] = mat[i][j]; 
            }
        }
        return temp;

    }

    public boolean compare(int mat[][], int target[][], int n){
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
        
    }
}