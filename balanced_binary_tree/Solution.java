package balanced_binary_tree;

import datastructure.TreeNode;
/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height(root)==-1){
        	return false;
        }else{
        	return true;
        }
    }
    
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        if(left==-1){
            return -1;
        }
        int right = height(root.right);
        if(right==-1){
            return -1;
        }
        
        if(Math.abs(left-right)>1){
            return -1;
        }else{
        	return Math.max(left, right)+1;
        }
    }
}
