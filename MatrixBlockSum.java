class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] prefix = new int [n][m];
        int[][] ans = new int [n][m];
        for(int i = 0; i<n; i++){
            prefix[i][0] = mat[i][0];
            for(int j =1; j <m ;j++){
                prefix[i][j] = mat[i][j] + prefix[i][j-1];
            }
        }
        for(int i = 0; i< n; i++){
            for(int j =0; j < m; j++){
                for(int x = Math.max(0,i-k); x<= Math.min(n-1,i+k); x++){
                    int left = Math.max(0, j-k);
                    int right = Math.min(m-1,j+k);
                    ans[i][j] += prefix[x][right];
                    if(left != 0){
                      ans[i][j] -= prefix[x][left-1];  
                    }
                }
            }
        }
        return ans;
    }
}

