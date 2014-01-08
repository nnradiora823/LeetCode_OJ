package three_sum_closest;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
	public int threeSumClosest(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if(num==null || num.length<3)
            return 0;
        Arrays.sort(num);
        int n = num.length;
        int sum = num[n-1]+num[n-2]+num[n-3];
        for(int i = 0; i<n; i++){
            int a = num[i];
            int low = i+1;
            int high = n-1;
            while(low<high){
                int b = num[low];
                int c = num[high];
                if(a+b+c==target){
                    return target;
                }
                else if(a+b+c<target){
                    sum = Math.abs(sum-target)<Math.abs(a+b+c-target)?sum:a+b+c;
                    low++;
                }
                else{
                    sum = Math.abs(sum-target)<Math.abs(a+b+c-target)?sum:a+b+c;
                    high--;
                }
            }
        }
        return sum;
    }
}
