package sum_root_to_leaf_number;

import datastructure.TreeNode;

public class Solution {
	public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root==null)
            return 0;
        return sumNumbersHelper(root, root.val);
    }
    
    public int sumNumbersHelper(TreeNode root, int path){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            return path;
        }
        
        int left = 0;
        if(root.left!=null)
            left = sumNumbersHelper(root.left, path*10+root.left.val);
        int right = 0;
        if(root.right!=null)
            right = sumNumbersHelper(root.right, path*10+root.right.val);
        return left+right;
    }
}
