package subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num==null || num.length==0)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        Set<String> set = new HashSet<String>();
        return subsetsWithDupHelper(num, set, 0);
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDupHelper(int[] num, Set<String> set, int index){
        ArrayList<ArrayList<Integer>> subsets = null;
        if(index==num.length){
            subsets = new ArrayList<ArrayList<Integer>>();
            subsets.add(new ArrayList<Integer>());
        }
        else{
            int digit = num[index];
            subsets = subsetsWithDupHelper(num, set, index+1);
            ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : subsets){
                ArrayList<Integer> newSubset = (ArrayList<Integer>)subset.clone();
                newSubset.add(0,digit);
                String key = "";
                for(int i : newSubset){
                    key+="("+String.valueOf(i)+")";
                }
                if(!set.contains(key)){
                    newSubsets.add(newSubset);
                    set.add(key);
                }
            }
            subsets.addAll(newSubsets);
        }
        return subsets;
    }
}
