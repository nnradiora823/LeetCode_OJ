package remove_duplicate_from_sorted_arrays_ii;

/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class Solution {
	public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A==null || A.length==0)
            return 0;
        int n = A.length;
        if(n<=2)
            return n;
        int cur = 1;
        for(int i = 2; i<n; i++){
            //check if the third one is identical
            if(A[i]==A[cur] && A[i]==A[cur-1])
                continue;
            else{
                A[++cur] = A[i];
            }
        }
        return cur+1;
    }
}
