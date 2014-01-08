package remove_nth_node_from_end_of_list;

import datastructure.ListNode;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head==null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i<n; i++){
            if(fast==null)
                return head;
            fast = fast.next;
        }
        ListNode pre = dummy;
        while(fast!=null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }
}
