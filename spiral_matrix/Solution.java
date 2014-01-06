package spiral_matrix;

import java.util.ArrayList;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */

public class Solution {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return res;
        spiralHelper(res, matrix, 0, matrix.length, matrix[0].length);
        return res;
    }
    
    public void spiralHelper(ArrayList<Integer> res, int[][] matrix, int layer, int rowSize, int colSize){
        
        if(rowSize<=0 || colSize<=0)
            return;
        
        //only one row left
        if(rowSize==1){
            for(int i = layer ; i<layer+colSize;i++){
                res.add(matrix[layer][i]);
            }
            return;
        }
        
        //only one col left
        if(colSize==1){
            for(int i = layer ; i<layer+rowSize;i++){
                res.add(matrix[i][layer]);
            }
            return;
        }
        
        //top from left to right
        for(int i = layer ; i<layer+colSize-1;i++){
            res.add(matrix[layer][i]);
        }
        
        //right from top to bottom
        for(int i = layer; i<layer+rowSize-1;i++){
            res.add(matrix[i][layer+colSize-1]);
        }
        
        //bottom from right to left
        for(int i = layer+colSize-1;i>layer;i--){
            res.add(matrix[rowSize+layer-1][i]);
        }
        
        //right from bottom to top
        for(int i = rowSize+layer-1;i>layer;i--){
            res.add(matrix[i][layer]);
        }
        
        spiralHelper(res, matrix, layer+1, rowSize-2, colSize-2);
    }
}
