package search_for_a_range;

/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class Solution {
	public int[] searchRange(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(A==null || A.length==0){
            return res;
        }
        int low = 0;
        int high = A.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(A[mid]<target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        if(A[low]!=target)
            return res;
        res[0] = low;
        
        high = A.length;
        while(low<high){
            int mid = (low+high)/2;
            if(A[mid]>target){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        res[1] = high-1;
        return res;
    }
}
