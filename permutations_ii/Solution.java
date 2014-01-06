package permutations_ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num==null || num.length==0)
            return new ArrayList<ArrayList<Integer>>();
        Set<String> set = new HashSet<String>();
        return permuteUniqueHelper(num, set, 0);
    }
    
    public ArrayList<ArrayList<Integer>> permuteUniqueHelper(int[] num, Set<String> set, int index){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(index==num.length){
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        int digit = num[index];
        ArrayList<ArrayList<Integer>> permutations = permuteUniqueHelper(num, set, index+1);
        for(ArrayList<Integer> list : permutations){
            for(int i = 0; i<=list.size(); i++){
                ArrayList<Integer> newlist = insertDigit(set, digit, list, i);
                if(newlist!=null)
                    res.add(newlist);
            }
        }
        return res;
    }
    
    public ArrayList<Integer> insertDigit(Set<String> set, int digit, ArrayList<Integer> oldlist, int index){
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<index;  i++){
            newlist.add(oldlist.get(i));
            sb.append("("+String.valueOf(oldlist.get(i))+")");
        }
        newlist.add(digit);
        sb.append("("+String.valueOf(digit)+")");
        for(int i = index; i<oldlist.size();  i++){
            newlist.add(oldlist.get(i));
            sb.append("("+String.valueOf(oldlist.get(i))+")");
        }
        String key = sb.toString();
        if(set.contains(key)){
            return null;
        }
        set.add(key);
        return newlist;
    }
}
