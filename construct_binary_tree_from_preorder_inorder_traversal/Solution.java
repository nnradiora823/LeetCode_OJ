package construct_binary_tree_from_preorder_inorder_traversal;

import java.util.HashMap;
import java.util.Map;

import datastructure.TreeNode;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */

/*
 * for example
 * 
 * 			  4
 * 			 / \
 * 		   2    5
 * 		 /  \    \
 *     1     3    6
 *     
 *     inorder: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 *     preorder: 4 -> 2 -> 1 -> 3 -> 5 -> 6 
 */

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, map, 0, preorder.length, 0);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> map, int preIndex, int size, int offset){
        if(size<=0)
            return null;
        int rootVal = preorder[preIndex];
        int length = map.get(rootVal)-offset;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, map, preIndex+1, length, offset);
        root.right = buildTreeHelper(preorder, map, preIndex+length+1, size-length-1, offset+length+1);
        return root;
    }
}	
