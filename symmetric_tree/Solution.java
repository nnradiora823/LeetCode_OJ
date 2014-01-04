package symmetric_tree;


import datastructure.TreeNode;
/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */

public class Solution {
	public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }
    
    public boolean isSymmetricHelper(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
        if(node1.val != node2.val)
            return false;
        return isSymmetricHelper(node1.left,node2.right) && isSymmetricHelper(node1.right, node2.left);
    }
}
