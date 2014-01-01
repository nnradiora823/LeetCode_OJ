package binary_tree_postorder_traversal;

/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.ArrayList;
import java.util.LinkedList;

import datastructure.TreeNode;

public class Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
	    if(root==null)
	        return res;
	    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	    stack.addFirst(root);
	    TreeNode pre = null;
	    while(!stack.isEmpty()){
	        TreeNode cur = stack.peekFirst();
	        // from top down
	        if(pre == null || cur == pre.left || cur == pre.right){
	            //only add one children, and left go first
	            if(cur.left!=null){
	                stack.addFirst(cur.left);
	            }
	            else if(cur.right!=null){
	                stack.addFirst(cur.right);
	            }
	        }
	        // from bottom up
	        else if(pre == cur.left){
	            if(cur.right!=null)
	                stack.addFirst(cur.right);
	        }
	        else{
	            res.add(cur.val);
	            stack.pollFirst();
	        }
	        pre = cur;
	    }
	    return res;
	}
}
