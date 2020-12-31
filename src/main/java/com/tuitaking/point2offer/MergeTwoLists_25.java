package com.tuitaking.point2offer;

import com.tuitaking.common.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * 0 <= 链表长度 <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(-1);
        ListNode node1=node;
        ListNode tail1=l1;
        ListNode tail2=l2;
        while(tail1!=null||tail2!=null){
            if(tail1!=null && tail2==null){
                node1.next=tail1;
                break;
            }
            if(tail2!=null&& tail1==null){
                node1.next=tail2;
                break;
            }
            if(tail1.val<tail2.val){
                node1.next=tail1;
                tail1=tail1.next;
            }else{
                node1.next=tail2;
                tail2=tail2.next;
            }
            node1=node1.next;
        }

        return node.next;
    }
}
