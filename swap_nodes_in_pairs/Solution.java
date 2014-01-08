package swap_nodes_in_pairs;

import datastructure.ListNode;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Solution {
	
	public ListNode swapPairs(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr1 = dummy;
        ListNode ptr2 = head;
        while(ptr2!=null && ptr2.next!=null){
            ListNode next = ptr2.next.next;
            ptr2.next.next = ptr1.next;
            ptr1.next = ptr2.next;
            ptr2.next = next;
            ptr1 = ptr2;
            ptr2 = ptr1.next;
        }
        return dummy.next;
    }
	
	public ListNode swapPairs2(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head==null)
            return null;
        ListNode prev = null;
        return swapPairsHelper(head,prev,1);
    }
    
    public ListNode swapPairsHelper(ListNode current, ListNode prev, int length){
        if(current.next == null && length%2==0){
            current.next = prev;
            prev.next = null;
            return current;
        }
        if(current.next == null && length%2==1){
            return current;
        }
        if(length%2==0){
            prev.next = swapPairsHelper(current.next, current, length+1);
            current.next = prev;
            return current;
        }
        return swapPairsHelper(current.next,current,length+1);
    }
}
