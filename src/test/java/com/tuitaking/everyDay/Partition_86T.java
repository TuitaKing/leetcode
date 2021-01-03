package com.tuitaking.everyDay;

import com.tuitaking.common.ListNode;
import com.tuitaking.common.MockUtil;
import org.junit.Test;

//1->4->3->2->5->2
public class Partition_86T {
    @Test
    public void test(){
       Partition_86 partition_86=new Partition_86();
        ListNode root=new ListNode(1);
        ListNode tail=root;
        int[] array=new int[0];
        for(int i : array){
            tail.next=new ListNode(i);
            tail=tail.next;
        }
        partition_86.partition(root,3);

    }
}
