package binary_tree_maximum_path_sum;

import datastructure.TreeNode;

public class Solution {
	private class Wrapper{
        int sum;
        public Wrapper(){
            sum = Integer.MIN_VALUE;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Wrapper maxSum = new Wrapper();
        helper(root, maxSum);
        return maxSum.sum;
    }
    
    public int helper(TreeNode root, Wrapper maxSum){
        if(root==null)
            return 0;
        int left = helper(root.left, maxSum);
        int right = helper(root.right, maxSum);
        
        int localM = root.val;
        localM+=Math.max(0,left);
        localM+=Math.max(0,right);
        
        maxSum.sum = Math.max(maxSum.sum, localM);
        //why only contain one path?
        return Math.max(left,right)>0?Math.max(left,right)+root.val:root.val;
    }
}
