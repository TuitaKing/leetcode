package com.tuitaking.point2offer;

import com.tuitaking.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePrint_06 {
    // 用链表存储数据或许会少很多操作
    public int[] reversePrint(ListNode head) {
        List<Integer> arr=new ArrayList<>();
        while (head.next!=null){
            arr.add(0,head.val);
            head=head.next;
        }
        int[] res=new int[arr.size()];
        for(int i = 0 ; i < arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}
