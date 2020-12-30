package com.tuitaking.array;

import com.tuitaking.common.ListNode;
import com.tuitaking.common.MockUtil;
import org.junit.Assert;
import org.junit.Test;

public class TwoSum_02T {
    @Test
    public void test(){
        TwoSum_02 twoSum_02=new TwoSum_02();
        ListNode node1=MockUtil.mockListNode(3,10);
        ListNode node2=MockUtil.mockListNode(3,9);
        ListNode node3= twoSum_02.addTwoNumbers(node1,node2);
        Assert.assertNotNull(node3);
    }

}
