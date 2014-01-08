package generate_parentheses;

import java.util.ArrayList;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> res = new ArrayList<String>();
        if(n==0)
            return res;
        ArrayList<String> tmp = new ArrayList<String>();
        generateParenthesisHelper(n, 0, 0, res, tmp);
        return res;
    }
    
    public void generateParenthesisHelper(int n, int left, int right, ArrayList<String> res, ArrayList<String> tmp){
         if(left>n || right>n)
            return;
            
        if(left==n && right==n){
            StringBuffer sb = new StringBuffer();
            for(String str : tmp){
                sb.append(str);
            }
            res.add(sb.toString());
            return;
        }
        
        if(left<n){
            tmp.add("(");
            generateParenthesisHelper(n, left+1, right, res, tmp);
            tmp.remove(tmp.size()-1);
        }
        
        if(left>right){
            tmp.add(")");
            generateParenthesisHelper(n, left, right+1, res, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
