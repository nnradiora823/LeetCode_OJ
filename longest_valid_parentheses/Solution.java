package longest_valid_parentheses;

import java.util.LinkedList;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class Solution {
	public int longestValidParentheses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s==null || s.length()==0)
            return 0;
        int maxLen = 0;
        int last = -1;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.addLast(i);
            }
            else{
                if(stack.isEmpty()){
                    last = i;
                }
                else{
                    stack.pollLast();
                    if(stack.isEmpty()){
                        maxLen = Math.max(maxLen, i-last);
                    }
                    else
                        maxLen = Math.max(maxLen, i-stack.peekLast());
                }
            }
        }
        return maxLen;
    }
}
