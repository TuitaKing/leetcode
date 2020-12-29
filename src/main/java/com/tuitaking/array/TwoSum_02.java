package com.tuitaking.array;

import com.tuitaking.common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_02 {
    // 此方法不能做超出int或者long最大值的解
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0 ;
        int j=0;
        int count=0;
        while (l1!=null || l2!=null){
            if(l1!=null){
                i+=Math.pow(10,count)*l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                j+=Math.pow(10,count)*l2.val;
                l2=l2.next;
            }
            count++;
        }
        int res=i+j;
        ListNode head=new ListNode(-1);
        ListNode next=head;
        while (res!=0){
            int tmp=res%10;
            ListNode current=new ListNode(tmp);
            next.next=current;
            next=next.next;
            res/=10;
        }
        if(head.next==null){
            return new ListNode(0);
        }else {
            return head.next;
        }
    }

    // 使用一位计算进位
    public ListNode addTwoNumbers_v1(ListNode l1, ListNode l2) {
        int pre=0;
        ListNode head=new ListNode(-1);
        ListNode tail =head;
        while (l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                tail.next=new ListNode((l1.val+l2.val+pre)%10);
                pre=(l1.val+l2.val+pre)/10;
                tail=tail.next;
            }
            if(l1==null){
                while (l1!=null){
                    tail.next=new ListNode(l1.val+pre);
                    tail=tail.next;
                    pre=0;
                }
            }
            if(l2==null){
                while (l2!=null){
                    tail.next=new ListNode(l2.val+pre);
                    tail=tail.next;
                    pre=0;
                }
            }
        }
        if(pre!=0){
            tail.next=new ListNode(1);
        }
        return head.next;
    }
    // leetcode上简洁的代码
    public ListNode addTwoNumbers_v2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        int flag = 0;
        while(l1!=null || l2!=null || flag!=0){
            p.next = new ListNode();
            p = p.next;
            Integer num =  (l1!=null?l1.val:0)+(l2!=null?l2.val:0)+flag;
            p.val = num%10;
            flag = num/10;
            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;

        }
        return head.next;
    }
}
