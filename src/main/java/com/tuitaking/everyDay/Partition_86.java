package com.tuitaking.everyDay;

import com.tuitaking.common.ListNode;

import java.util.List;


/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例：
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Partition_86 {
    // 3,1,2
    public ListNode partition(ListNode head, int x) {
        ListNode res=new ListNode(-1);
        res.next=head;
        ListNode lowTail=res;
        ListNode tail=res;
        ListNode pre=res;
        while (tail!=null&&tail.next!=null){
            pre=tail;
            ListNode curr=tail.next;
            if( curr.val<x){
                tail.next=tail.next.next;
                curr.next=lowTail.next;
                lowTail.next=curr;
                lowTail=lowTail.next;
            }
            tail=tail.next;
        }
        if(tail!=null && tail.val<x){
            pre.next=null;
            tail.next=lowTail.next;
            lowTail.next=tail;
        }

        return  res.next;
    }


    public ListNode partition_v1(ListNode head, int x) {
        ListNode p=head;
        ListNode small=new ListNode(0);//把小于x值得结点链接起来
        ListNode big=new ListNode(0);//把大于x值得结点链接起来
        ListNode rear_small=small;//尾插法的尾结点
        ListNode rear_big=big;
        while(p!=null){
            if(p.val<x){//小于x的链接起来
                rear_small.next=p;
                rear_small=p;
            }else{
                rear_big.next=p;
                rear_big=p;
            }
            p=p.next;
        }
        if(small.next!=null){//有小于x的结点
            head=small.next;
            rear_small.next=big.next;
            rear_big.next=null;
        }else{//全部都是大于x的结点
            head=big.next;
        }
        return head;

    }

}
