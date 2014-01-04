package search_in_rotated_sorted_array_ii;

/*
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */
public class Solution {
	public boolean search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A==null)
            return false;
        int low = 0;
        int high = A.length-1;
        return searchHelper(A, target, low, high);
    }
    
    public boolean searchHelper(int[] A, int target, int low, int high){
        if(low>high)
            return false;
        int mid = (low + high)/2;
        
        if(A[mid]==target){
            return true;
        }
        if(A[low]<A[mid]){
            if(A[mid]>=target && A[low]<=target){
                return searchHelper(A, target, low, mid-1);
            }
            else{
                return searchHelper(A, target, mid+1, high);
            }
        }
        else if(A[low]>A[mid]){
            if(A[mid]<=target && A[high]>=target){
                return searchHelper(A, target, mid+1, high);
            }
            else{
                return searchHelper(A, target, low, mid-1);
            }
        }
        else{
            if(A[mid]!=A[high]){
                return searchHelper(A, target, mid+1, high);
            }
            else{
                return searchHelper(A, target, low, mid-1) || searchHelper(A, target, mid+1, high);
            }
        }
    }
}
