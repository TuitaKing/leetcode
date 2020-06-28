package com.tuitaking.array;

import com.tuitaking.common.ListNode;
import com.tuitaking.common.MockUtil;
import org.junit.Assert;
import org.junit.Test;

public class MergeKlists_23Test {

    @Test
    public void test(){
        MergeKLists_23 mergeKLists_23=new MergeKLists_23();
        ListNode root=MockUtil.mockSortedList(4);
        ListNode root1=MockUtil.mockSortedList(4);
        ListNode root2=MockUtil.mockSortedList(4);
        ListNode root3=MockUtil.mockSortedList(4);
        mergeKLists_23.mergeKLists(new ListNode[]{root,root1,root2,root3});
//        ListNode a= merge(root,root1);
        Assert.assertNotNull(root);
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
