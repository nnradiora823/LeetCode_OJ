package valid_binary_search_tree;

import datastructure.TreeNode;
/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

public class Solution {
 
	public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isValidBSTHelper(root, min, max);
    }
    
    public boolean isValidBSTHelper(TreeNode root, int min, int max){
        if(root==null)
            return true;
        if(root.val<=min || root.val>=max)
            return false;
        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }
}
