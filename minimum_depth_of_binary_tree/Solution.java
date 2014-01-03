package minimum_depth_of_binary_tree;

import datastructure.TreeNode;

/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
	public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return helper(root, 1);
    }
    
    public int helper(TreeNode root, int depth){
        if(root == null){
            return depth-1;
        }
        
        int left = helper(root.left,depth+1);
        int right = helper(root.right,depth+1);
        
        //make sure that the node is leaf node
        if(left==depth){
            return right;
        }
        if(right==depth){
            return left;
        }
        
        return Math.min(left,right);
    }
}
