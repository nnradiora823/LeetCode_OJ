package copy_list_with_random_pointer;

import java.util.HashMap;

import datastructure.RandomListNode;

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(head==null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode ptr1 = head;
        RandomListNode ptr2 = newHead;
        while(ptr1!=null){
            ptr1 = ptr1.next;
            if(ptr1!=null){
                ptr2.next = new RandomListNode(ptr1.label);
                ptr2 = ptr2.next;
                map.put(ptr1, ptr2);
            }
            else
                ptr2.next = null;
        }
        
        //copy random pointer
        ptr1 = head;
        ptr2 = newHead;
        while(ptr1!=null){
            if(ptr1.random==null){
                ptr2.random = null;
            }
            else{
                ptr2.random = map.get(ptr1.random);
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return newHead;
    }
}
