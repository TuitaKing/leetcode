package com.tuitaking.array;

import com.tuitaking.common.ListNode;

public class GetKthFromEnd_offer2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int index=k;
        ListNode quick=head;
        while (index>=0){
            quick=quick.next;
            index--;
        }
        ListNode slow=head;
        while (quick.next!=null){
            quick=quick.next;
            slow=slow.next;
        }
        return slow;
    }
}
