package com.tuitaking.array;

import com.tuitaking.common.ListNode;

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
 *
 *  合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  */
public class MergeKLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
//        ForkJoinTask<ListNode> tak=new MergeAction(lists);
        ForkJoinTask<ListNode> tak=new MergeAction2(lists,0,lists.length-1);

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
                return mergeTwoLists(leftRes,rightRes);
            }else {
                if(nodes.length==2){
                  return mergeTwoLists(nodes[0],nodes[1]);
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

class MergeAction2 extends RecursiveTask<ListNode>{
    ListNode[] nodes;
    int left;
    int right;
    public MergeAction2(ListNode[] nodes,int left,int right){
        this.nodes=nodes;
        this.left=left;
        this.right=right;
    }
    @Override
    protected ListNode compute() {

        if(left==right){
            return nodes[left];
        }
        if(right-left==1){
            return mergeTwoLists(nodes[left],nodes[right]);
        }
        int mid=(left+right)/2;
        MergeAction2 left=new MergeAction2(nodes,this.left,mid);
        MergeAction2 right=new MergeAction2(nodes,mid+1,this.right);
        left.fork();
        right.fork();
        ListNode leftRes=left.join();
        ListNode rightRes=right.join();
        return   mergeTwoLists(leftRes,rightRes);

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