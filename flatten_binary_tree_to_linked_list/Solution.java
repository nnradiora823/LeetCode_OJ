package flatten_binary_tree_to_linked_list;

import datastructure.TreeNode;

/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class Solution {
	public void flatten(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
         if(root==null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(root.left!=null){
            root.right = left;
            root.left = null;
            TreeNode rightmost = left;
            while(rightmost.right!=null){
                rightmost = rightmost.right;
            }
            rightmost.right = right;
        }
        flatten(root.right);
    }
}
