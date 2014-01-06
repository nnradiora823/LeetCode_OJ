package combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num==null || num.length==0)
            return null;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        int index = 0;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        combinationSumHelper(num, target, index, comb, res, map);
        return res;
    }
    
    public void combinationSumHelper(int[] num, int target, int index, LinkedList<Integer> comb, ArrayList<ArrayList<Integer>> res, HashMap<String, Boolean> map){
        
        if(target==0){
            ArrayList<Integer> newComb = new ArrayList<Integer>();
            StringBuffer sb = new StringBuffer();
            for(int i : comb){
                newComb.add(i);
                sb.append((char)(i+'0'));
            }
            String key = sb.toString();
            if(map.containsKey(key))
                return;
            map.put(key, true);
            res.add(newComb);
            return;
        }
        for(int i = index; i<num.length; i++){
            if(target<num[i])
                return;
            comb.addLast(num[i]);
            combinationSumHelper(num, target-num[i], i+1, comb, res, map);
            comb.pollLast();
        }
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum3(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num==null || num.length==0)
            return new ArrayList<ArrayList<Integer>>();
        Set<String> set = new HashSet<String>();
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        combinationSumHelper(num, set, res, target, 0);
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> combinationSumHelper(int[] num, Set<String> set, ArrayList<ArrayList<Integer>> res, int target, int index){
        
        ArrayList<ArrayList<Integer>> allCombinations = new ArrayList<ArrayList<Integer>>();
        
        if(index==num.length || num[index]>target){
            allCombinations.add(new ArrayList<Integer>());
            set.add("()");
            return allCombinations;
        }
        
        int digit = num[index];
        
        ArrayList<ArrayList<Integer>> tmp = combinationSumHelper(num, set, res, target, index+1);
        allCombinations.addAll(tmp);
        
        for(ArrayList<Integer> combination : tmp){
            ArrayList<Integer> newcomb = (ArrayList<Integer>)combination.clone();
            newcomb.add(0,digit);
            int sum = 0;
            StringBuffer sb = new StringBuffer();
            for(int i : newcomb){
                sb.append("("+i+")");
                sum+=i;
            }
            String key = sb.toString();
            
            if(sum<target && !set.contains(key)){
                allCombinations.add(newcomb);
                set.add(key);
            }
            else if(sum==target && !set.contains(key)){
                res.add(newcomb);
                set.add(key);
            }
        }
        return allCombinations;
    }
}
