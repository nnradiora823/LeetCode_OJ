package single_number_i;

/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {
	public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A==null || A.length==0)
            return -1;
        int n = A.length;
        int res = 0;
        for(int i = 0;i < n; i++){
            res = res ^ A[i];
        }
        return res;
    }
}
