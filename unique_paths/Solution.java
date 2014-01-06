package unique_paths;
/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
 */
public class Solution {
	public final int MAX_ROW = 100;
    public final int MAX_COL = 100;
    
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[][] dp = new int[MAX_ROW+2][MAX_COL+2];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                    dp[i][j] = -1;
            }
        }
        return uniquePathHelper(dp, 1, 1, m, n);
    }
    
    public int uniquePathHelper(int[][] dp, int row, int col, int m, int n){
        if(row == m && col ==n)
            return 1;
        if(row > m || col > n)
            return 0;
        if(dp[row+1][col]==-1)
            dp[row+1][col] = uniquePathHelper(dp, row+1, col, m, n);
        if(dp[row][col+1]==-1)
            dp[row][col+1] = uniquePathHelper(dp, row, col+1, m, n);
        return dp[row+1][col]+dp[row][col+1];
    }
}
