package sort_list;

import datastructure.ListNode;

/*
 * Sort a linked list in O(n log n) time using constant space complexity
 */

public class Solution {

	public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null || head.next==null)
            return head;
        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        return mergeSort(head, tail);
    }
    
    public ListNode mergeSort(ListNode head, ListNode tail){
        if(head==null && tail==null){
            return null;
        }
        if(head!=tail){
            ListNode fast = head;
            ListNode slow = head;
            while(fast!=tail && fast.next!=tail){
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode frontHead = head;
            ListNode frontTail = slow;
            ListNode backHead = slow.next;
            ListNode backTail = tail;
            frontTail.next = null;
            backTail.next = null;
            ListNode front = mergeSort(frontHead, frontTail);
            ListNode back = mergeSort(backHead, backTail);
            return merge(front, back);
        }
        else{
            return head;
        }
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null && l2==null)
            return null;
        if(l1==null || l2==null)
            return l1==null?l2:l1;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        
        if(l1!=null){
            pre.next = l1;
        }
        else if(l2!=null){
            pre.next = l2;
        }
        return dummy.next;
    }

}
