package combinations;

import java.util.ArrayList;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n<k)
            return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(k==1){
            for(int i = 1; i<=n; i++){
                ArrayList<Integer> set = new ArrayList<Integer>();
                set.add(i);
                res.add(set);
            }
            return res;
        }
        for(int i = n; i>=k; i--){
            for(ArrayList<Integer> tmp: combine(i-1,k-1)){
                tmp.add(i);
                res.add(tmp);
            }
        }
        return res;
    }
}
