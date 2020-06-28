package com.tuitaking.array;

import com.tuitaking.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * /**
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 *  */
public class MergeKLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ForkJoinTask<ListNode> tak=new MergeAction(lists);
        ListNode node= ForkJoinPool.commonPool().invoke(tak);
        return node;
    }
}


class MergeAction extends RecursiveTask<ListNode> {
    ListNode[] nodes;
    public MergeAction(ListNode[] list){
        this.nodes=list;
    }
    @Override
    protected ListNode compute() {
            if(nodes.length>2){
             ForkJoinTask.invokeAll(createSubMerge());
            }else {
                ListNode daa=merge(nodes[0],nodes[1]);
                return daa ;
            }
            return null;
    }
    private ListNode merge(ListNode left,ListNode right){
        if(left.next==null || right.next==null){
            return null;
        }
        ListNode root=new ListNode(-1);
        ListNode tail=root;
        while (left!=null) {
                if(right!=null && left.val<=right.val){
                    tail.next=right;
                    right=right.next;
                }else {
                    tail.next=left;
                    left=left.next;
                }
                    tail =tail.next;
        }
        if(right!=null){
            while (right!=null){
                tail.next=right;
                tail=tail.next;
                right=right.next;
            }
        }

        return root.next;
    }
    private List<MergeAction> createSubMerge(){
            List<MergeAction> actions=new ArrayList<>();
            ListNode[] left=new ListNode[nodes.length/2];
            ListNode[] right=new ListNode[nodes.length/2];
            System.arraycopy(nodes,0,left,0,nodes.length/2);
            System.arraycopy(nodes,nodes.length/2,right,0,nodes.length/2);
            actions.add(new MergeAction(left));
            actions.add(new MergeAction(right));
            return actions;
    }
}