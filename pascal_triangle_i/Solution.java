package pascal_triangle_i;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows==0)
            return res;
        res.add(new ArrayList<Integer>(Arrays.asList(1)));
        for(int i = 1; i<numRows; i++){
            ArrayList<Integer> par = res.get(i-1);
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j<=par.size(); j++){
                if(j==0){
                    row.add(0+par.get(j));
                }
                else if(j==par.size()){
                    row.add(par.get(j-1)+0);
                }
                else{
                    row.add(par.get(j)+par.get(j-1));
                }
            }
            res.add(row);
        }
        return res;
    }
	
	/*
	 *  Over flow
	 *  
	 public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows==0)
            return res;
        res.add(new ArrayList(Arrays.asList(1)));
        for(int i = 1; i<numRows; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j = 0; j<=i; j++){
                row.add(combination(i,j));
            }
            res.add(row);
        }
        return res;
    }
    
    public int combination(int n, int k){
        if(n==0 && k==0)
            return 1;
        if(k==0)
            return 1;
        if(k>n/2){
            k=n-k;
        }
        int up = 1;
        int down = 1;
        for(int i = 0; i<k; i++){
            up*=n;
            down*=(k-i);
            n=n-1;
        }
        return up/down;
    }
	 */
}
