package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<3)
            return res;
        Arrays.sort(num);
        int n = num.length;
        Set<String> set = new HashSet<String>();
        ArrayList<Integer> sum = null;
        for(int i = 0; i<n; i++){
            int a = num[i];
            int low = i+1;
            int high = n-1;
            while(low<high){
                int b = num[low];
                int c = num[high];
                if(a+b+c==0){
                    String key = String.valueOf(a)+"+"+String.valueOf(b)+"+"+String.valueOf(c);
                    if(!set.contains(key)){
                        sum = new ArrayList<Integer>();
                        sum.add(a);
                        sum.add(b);
                        sum.add(c);
                        set.add(key);
                        res.add(sum);
                    }
                    low++;
                    high--;
                }
                else if(a+b+c<0){
                    low++;
                }
                else
                    high--;
            }
        }
        return res;
    }
}
