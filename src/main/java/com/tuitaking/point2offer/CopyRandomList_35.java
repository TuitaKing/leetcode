package com.tuitaking.point2offer;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CopyRandomList_35 {
    // 计划是，现在每个节点后添加一个相同数的节点，然后将新增的节点里面的random 与 设置为前一个数的random的next
    public Node copyRandomList(Node head) {
        Node tmp = head;
        while (tmp != null) {
            Node cur = new Node(tmp.val);
            cur.next = tmp.next;
            tmp.next = cur;
            tmp = cur.next;
        }
        tmp = head;
        Node tail = tmp;
        while (tail!=null&&tail.next != null) {
            tail.next.random = tail.random!=null?tail.random.next:null;
            tail = tail.next.next;
        }
        tail = tmp.next;
        Node result=tail;
        while (tail!=null&&tail.next != null) {
            tail.next = tail.next.next;
            tail=tail.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node2.random=node4;
        node4.random=node1;
        node1.random=node3;
        CopyRandomList_35 copyRandomList_35=new CopyRandomList_35();
        copyRandomList_35.copyRandomList(node1);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}