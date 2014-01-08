package next_permutation;

import java.util.Arrays;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
Discuss


 */
public class Solution {
	public void nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num==null || num.length==0)
            return;
        int lastUp = -1;
        int n = num.length;
        for(int i = 0; i<n-1; i++){
            if(num[i]<num[i+1])
                lastUp = i;
        }
        
        if(lastUp==-1){
            reverse(num, 0, n-1);
        }
        else{
            int max = -1;
            for(int i = 0; i<n; i++){
                if(num[i]>num[lastUp])
                    max = i;
            }
            swap(num, lastUp, max);
            reverse(num, lastUp+1, n-1);
        }
    }
    
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] =tmp;
    }
    
    public void reverse(int[] num, int start, int end){
        if(start>=end)
            return;
        for(int i = 0; i<=(end-start)/2; i++){
            int tmp = num[start+i];
            num[start+i] = num[end-i];
            num[end-i] = tmp;
        }
    }
}
