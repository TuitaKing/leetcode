package com.tuitaking.array;

import com.tuitaking.common.ListNode;

public class MergeKList_23_v1 {
    public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length <= 0) {
        return null;
    }
    return mergeKLists(lists, 0, lists.length-1);
}


    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if(right <= left ) {
            return lists[left];
        } else if(right - left == 1) {
            return mergeTwoLists(lists[left], lists[right]);
        } else {
            int mid = (right+left)/2;
            return mergeTwoLists(mergeKLists(lists, left, mid), mergeKLists(lists,mid+1, right));
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if(l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }

        return head.next;
    }
}
