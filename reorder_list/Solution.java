package reorder_list;

/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
import datastructure.ListNode;

public class Solution {

	public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(head==null || head.next==null || head.next.next==null)
            return;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        ListNode mid = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if(fast!=null){
            mid = slow;
            pre.next=null;
        }
        else{
            mid = slow.next;
            slow.next = null;
        }
        
        //reverse the second list
        pre = null;
        while(mid!=null){
            ListNode next = mid.next;
            mid.next=pre;
            pre = mid;
            mid = next;
        }
        ListNode l1 = head;
        ListNode l2 = pre;
        
        //twist these two lists
        ListNode dummy = new ListNode(0);
        pre = dummy;
        boolean isFirst = true;
        while(l1!=null && l2!=null){
            if(isFirst){
                pre.next = l1;
                l1=l1.next;
            }
            else{
                pre.next = l2;
                l2=l2.next;
            }
            pre = pre.next;
            isFirst = !isFirst;
        }
        if(l1!=null)
            pre.next = l1;
        else if(l2!=null)
            pre.next = l2;
        head = dummy.next;
    }
}
