package binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */

import datastructure.TreeNode;

public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.addFirst(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pollFirst();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
