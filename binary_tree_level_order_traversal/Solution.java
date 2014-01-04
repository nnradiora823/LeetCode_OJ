package binary_tree_level_order_traversal;

import java.util.ArrayList;

import datastructure.TreeNode;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */

public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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
                if(node.left!=null)
                    children.add(node.left);
                if(node.right!=null)
                    children.add(node.right);
            }
            res.add(row);
            par = children;
        }
        return res;
    }
}
