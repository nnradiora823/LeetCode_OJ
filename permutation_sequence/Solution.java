package permutation_sequence;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive
 */

public class Solution {
	public String getPermutation(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n==0 || k==0 || getFactorial(n)<k)
            return null;
        int[] factorBuffer = new int[n];
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i<n; i++){
            factorBuffer[i] = getFactorial(i);
            array.add(i+1);
        }
        k--;
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        while(n>0){
            int index = k/factorBuffer[n-1];
            indexes.add(index);
            k -= index*factorBuffer[n-1];
            n--;
        }
        StringBuffer sb = new StringBuffer();
        for(int index : indexes){
            int digit = array.get(index);
            sb.append((char)('0'+digit));
            array.remove(index);
        }
        return sb.toString();
    }
    
    public int getFactorial(int n){
        if(n==0 || n==1)
            return 1;
        int res = 1;
        while(n>=1){
            res*=n;
            n--;
        }
        return res;
    }
}
