package partition_list;

import datastructure.ListNode;

/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class Solution {
	public ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head==null || head.next==null)
            return head;
        ListNode frontHead = null;
        ListNode frontTail = null;
        ListNode backHead = null;
        ListNode backTail = null;
        
        ListNode cur = head;
        
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = null;
            if(cur.val<x){
                if(frontHead==null){
                    frontHead = cur;
                    frontTail = cur;
                }
                else{
                    frontTail.next = cur;
                    frontTail = frontTail.next;
                }
            }
            else{
                if(backHead==null){
                    backHead = cur;
                    backTail = cur;
                }
                else{
                    backTail.next = cur;
                    backTail = backTail.next;
                }
            }
            cur = next;
        }
        
        if(frontHead==null)
            return backHead;
        frontTail.next = backHead;
        return frontHead;
    }
}
