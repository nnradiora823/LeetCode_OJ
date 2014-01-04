package recover_binary_search_tree;

import java.util.ArrayList;
import java.util.Collections;

import datastructure.TreeNode;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */

public class Solution {
	public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return;
        ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
        ArrayList<Integer> ref = new ArrayList<Integer>();
        recoverTreeHelper(tmp, ref, root);
        Collections.sort(ref);
        for(int i = 0; i<ref.size(); i++){
            if(tmp.get(i).val!=ref.get(i)){
                tmp.get(i).val = ref.get(i);
            }
        }
    }
    
    public void recoverTreeHelper(ArrayList<TreeNode> tmp, ArrayList<Integer> ref, TreeNode root){
        if(root==null)
            return;
        recoverTreeHelper(tmp, ref, root.left);
        tmp.add(root);
        ref.add(root.val);
        recoverTreeHelper(tmp, ref, root.right);
    }
}
