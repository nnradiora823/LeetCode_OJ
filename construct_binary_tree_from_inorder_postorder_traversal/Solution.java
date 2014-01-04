package construct_binary_tree_from_inorder_postorder_traversal;

import java.util.HashMap;
import java.util.Map;

import datastructure.TreeNode;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

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
 *     postorder: 1 -> 3 -> 2 -> 6 -> 5 -> 4 
 */
public class Solution {
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0)
	            return null;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i = 0; i<inorder.length; i++){
	            map.put(inorder[i],i);
	        }
	        return buildTreeHelper(postorder, map, 0, postorder.length, 0);
	    }
	    
	    public TreeNode buildTreeHelper(int[] postorder, Map<Integer, Integer> map, int postIndex, int size, int offset){
	        
	        if(size<=0)
	            return null;
	        int rootVal = postorder[postIndex+size-1];
	        int length = map.get(rootVal)-offset;
	        TreeNode root = new TreeNode(rootVal);
	        root.left = buildTreeHelper(postorder, map, postIndex, length, offset);
	        root.right = buildTreeHelper(postorder, map, postIndex+length, size-length-1, offset+length+1);
	        return root;
	    }
}
