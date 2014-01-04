package binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.HashMap;

import datastructure.TreeNode;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return res;
        ArrayList<TreeNode> par = new ArrayList<TreeNode>();
        par.add(root);
        while(!par.isEmpty()){
            ArrayList<TreeNode> children = new ArrayList<TreeNode>();
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(TreeNode node : par){
                row.add(node.val);
                if(node.left!=null){
                    children.add(node.left);
                }
                if(node.right!=null){
                    children.add(node.right);
                }
            }
            res.add(0,row);
            par = children;
        }
        return res;
    }
}
