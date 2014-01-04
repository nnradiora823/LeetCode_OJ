package maximum_depth_of_binary_tree;

import datastructure.TreeNode;

/*
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Solution {

	 public int maxDepth(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(root == null){
	            return 0;
	        }
	        
	        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	    }

}
