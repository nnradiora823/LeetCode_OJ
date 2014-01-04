package set_matrix_zeroes;

/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.


Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */

public class Solution {
	public void setZeroes(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean[] rowFlag = new boolean[matrix.length];
        boolean[] colFlag = new boolean[matrix[0].length];
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                if(rowFlag[i] || colFlag[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
	
	public void setZeroesWithoutExtra(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(matrix==null || matrix.length==0)
            return;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean zeroRow = false, zeroCol = false;
        
        for(int i = 0; i<row; i++){
            if(matrix[i][0]==0)
                zeroCol = true;
        }
        
        for(int i = 0; i<col; i++){
            if(matrix[0][i]==0)
                zeroRow = true;
        }
        
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        
        for(int i = 0; i<col; i++){
            if(zeroRow){
                matrix[0][i] = 0;
            }
        }
        
        for(int i = 0; i<row; i++){
            if(zeroCol){
                matrix[i][0] = 0;
            }
        }
    }
}
