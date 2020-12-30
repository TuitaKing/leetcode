package com.tuitaking.point2offer;

import com.tuitaking.common.ListNode;
import com.tuitaking.common.MockUtil;
import org.junit.Test;

public class ReverseList_24T {
    @Test
    public void test(){
        ReverseList_24 reverseList_24=new ReverseList_24();
        ListNode head=MockUtil.mockSortedList(4);
        ListNode node=reverseList_24.reverseList(head);
        System.out.println(node);
    }
}
