package search_a_2D_matrix;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(matrix==null || matrix.length==0)
            return false;
        int low = 0, high = matrix.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            else if(matrix[mid][0]>target){
                high = mid-1;
            }
            else if(matrix[mid+1][0]>target){
                low = mid;
                break;
            }
            else{
                low = mid+1;
            }
        }
        
        int row = low;
        low = 0;
        high = matrix[0].length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[row][mid]==target)
                return true;
            else if(matrix[row][mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}
