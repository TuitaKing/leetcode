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
        if(lists.length==0){
            return null;
        }
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
//             ForkJoinTask.invokeAll(createSubMerge());
                ListNode[] left=new ListNode[nodes.length/2];
                ListNode[] right=new ListNode[(nodes.length+1)/2];
                System.arraycopy(nodes,0,left,0,nodes.length/2);
                System.arraycopy(nodes,nodes.length/2,right,0,(nodes.length+1)/2);
                MergeAction mergeActionLeft=new MergeAction(left);
                MergeAction mergeActionRight=new MergeAction(right);
                mergeActionLeft.fork();
                mergeActionRight.fork();
                ListNode leftRes= mergeActionLeft.join();
                ListNode  rightRes=mergeActionRight.join();
                return merge(leftRes,rightRes);
            }else {
                if(nodes.length==2){
                  return merge(nodes[0],nodes[1]);
                }else {
                    return  nodes[0];
                }

            }
    }
    private ListNode merge(ListNode left,ListNode right){
//        if(left==null || right!=null){
//            return right;
//        }
//        if(left!=null || right==null){
//            return left;
//        }
        if(left==null && right==null){
            return null;
        }
        ListNode root=new ListNode(-1);
        ListNode tail=root;
        while (true) {
            while (left!=null && right!=null && right.val<=left.val){
                ListNode tmp=right.next;
                right.next=null;
                tail.next=right;
                tail=tail.next;
                right=tmp;
            }
            while (left!=null && right!=null && left.val<right.val){
                ListNode tmp=left.next;
                left.next=null;
                tail.next=left;
                tail=tail.next;
                left=tmp;
            }
            if(left==null && right!=null){
                    tail.next=right;
                    break;
            }
            if(left!=null && right==null){
                tail.next=left;
                break;
            }
//                if(right!=null && left.val>=right.val){
//                    ListNode tmp=right.next;
//                    tail.next=right;
//                    right.next=null;
//                    right=tmp;
//                }else {
//                    ListNode tmp=left.next;
//                    tail.next=left;
//                    left.next=null;
//                    left=tmp;
//                }
//                    tail =tail.next;
        }
//        if(right!=null){
//            while (right!=null){
//                tail.next=right;
//                tail=tail.next;
//                right=right.next;
//            }
//        }

        return root.next;
    }
//    private List<MergeAction> createSubMerge(){
//            List<MergeAction> actions=new ArrayList<>();
//            ListNode[] left=new ListNode[nodes.length/2];
//            ListNode[] right=new ListNode[nodes.length/2];
//            System.arraycopy(nodes,0,left,0,nodes.length/2);
//            System.arraycopy(nodes,nodes.length/2,right,0,nodes.length/2);
//            actions.add(new MergeAction(left));
//            actions.add(new MergeAction(right));
//            return actions;
//    }
}