package convert_sorted_list_to_BST;

import java.util.HashMap;

import datastructure.ListNode;
import datastructure.TreeNode;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)
            return null;
        HashMap<Integer, ListNode> pseudoArray = new HashMap<Integer, ListNode>();
        ListNode ptr = head;
        int i = 0;
        while(ptr!=null){
            pseudoArray.put(i, ptr);
            ptr=ptr.next;
            i++;
        }
        
        return sortedListToBSTHelper(pseudoArray, 0, i-1);
    }
    
    public TreeNode sortedListToBSTHelper(HashMap<Integer, ListNode> pseudoArray, int low, int high){
        if(low>high)
            return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(pseudoArray.get(mid).val);
        root.left = sortedListToBSTHelper(pseudoArray, low, mid-1);
        root.right = sortedListToBSTHelper(pseudoArray, mid+1, high);
        return root;
    }
}
