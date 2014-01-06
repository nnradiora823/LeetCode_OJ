package first_missing_positive;

/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */

public class Solution {
	public int firstMissingPositive(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        for(int i = 0; i<n; i++){
            if(A[i]>0 && A[i]<=n){
                if(A[i]-1!=i && A[A[i]-1] != A[i]){
                    swap(A,A[i]-1, i);
                    i--;
                }
            }
        }
        
        for(int i = 0; i<n;i++){
            if(A[i]-1!=i)
                return i+1;
        }
        return n+1;
    }
    
    public void swap(int[] A, int a, int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
        return;
    }
}
