package maximum_subarray;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

public class Solution {
	public int maxSubArray(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int res = A[0];
        int sum = 0;
        for(int i = 0; i<A.length; i++){
            sum = Math.max(sum+A[i],A[i]);
            res = Math.max(res,sum);
        }
        return res;
    }
}
