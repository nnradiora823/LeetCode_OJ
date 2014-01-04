package merge_sorted_array;
/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class Solution {
	public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int mIndex = m-1;
        int nIndex = n-1;
        int mergeIndex = m+n-1;
        
        while(mergeIndex>=0 && mIndex>=0 && nIndex>=0){
            if(A[mIndex]>B[nIndex]){
                A[mergeIndex] = A[mIndex];
                mIndex--;
            }
            else{
                A[mergeIndex] = B[nIndex];
                nIndex--;
            }
            mergeIndex--;
        }
        
        while(nIndex>=0){
            A[mergeIndex] = B[nIndex];
            nIndex--;
            mergeIndex--;
        }
    }
}
