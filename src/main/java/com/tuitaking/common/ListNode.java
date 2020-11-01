package com.tuitaking.common;

public class ListNode implements Comparable<ListNode> {
    public  int val;
    public  ListNode next;
    public  ListNode(int x) { val = x; }

    @Override
    public int compareTo(ListNode o) {
        return this.val-o.val;
    }
}