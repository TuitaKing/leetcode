package com.tuitaking.array;

import com.tuitaking.common.ListNode;
import com.tuitaking.common.MockUtil;
import org.junit.Assert;
import org.junit.Test;

public class MergeKlists_23Test {

    @Test
    public void test(){
        MergeKLists_23 mergeKLists_23=new MergeKLists_23();
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(4);
        listNode1.next.next=new ListNode(5);
        ListNode listNode2=new ListNode(1);
        listNode2.next=new ListNode(3);
        listNode2.next.next=new ListNode(4);
        ListNode listNode3=new ListNode(2);
        listNode3.next=new ListNode(6);
        ListNode root= mergeKLists_23.mergeKLists(new ListNode[]{null,listNode1});
        Assert.assertNotNull(root);
//        ListNode root0=MockUtil.mockSortedList(10);
//        ListNode root1=MockUtil.mockSortedList(10);
//        ListNode root2=MockUtil.mockSortedList(10);
////        ListNode root3=MockUtil.mockSortedList(4);
//       ListNode root= mergeKLists_23.mergeKLists(new ListNode[]{root0,root1,root2});
////        ListNode a= merge(root,root1);
//        int tmp=root.val;
//        while (root.next!=null){
//            int current=root.val;
//            int next=root.next.val;
//            if(current>next){
//                Assert.assertNotNull(null);
//            }
//            root=root.next;
//        }
//        Assert.assertNotNull(root);
//        mergeKLists_23.mergeKLists(MockUtil.mockListNode(10,))
    }
//    private ListNode merge(ListNode left,ListNode right){
//        if(left.next==null && right.next==null){
//            return null;
//        }
//        ListNode root=new ListNode(-1);
//        ListNode tail=root;
//        while (left.next!=null) {
//            if(right==null){
//                break;
//            }
//            if(left.val<=right.val){
//                tail.next=right;
//                right=right.next;
//            }else {
//                tail.next=left;
//                left=left.next;
//            }
//            tail =tail.next;
//        }
//
//        return root.next;
//    }
}
