package trapping_rain_water;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 */

public class Solution {
	public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A==null || A.length<3)
            return 0;
        int sum = 0;
        int left = 0;
        int right = A.length-1;
        int cur = 0;
        while(left<right){
            if(A[left]<=A[right]){
                cur = left + 1;
                while(A[left]>A[cur]){
                    sum += (A[left]-A[cur]);
                    cur++;
                }
                left = cur;
            }
            else{
                cur = right-1;
                while(A[right]>A[cur]){
                    sum+=(A[right]-A[cur]);
                    cur--;
                }
                right = cur;
            }
        }
        return sum;
    }
}
