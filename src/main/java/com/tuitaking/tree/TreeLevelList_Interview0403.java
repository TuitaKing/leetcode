package com.tuitaking.tree;

import com.tuitaking.common.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 示例：
 输入：[1,2,3,4,5,null,7,8]

 1
 /  \
 2    3
 / \    \
 4   5    7
 /
 8

 输出：[[1],[2,3],[4,5,7],[8]]

 https://leetcode-cn.com/problems/list-of-depth-lcci/
 */
public class TreeLevelList_Interview0403 {

    /**
     * 从题目来看就是
     * @param tree
     * @return
     */

    public ListNode[] listOfDepth(TreeNode tree){
        Queue<TreeNode> queue=new LinkedBlockingDeque();
        queue.offer(tree);
        List<ListNode> res=new ArrayList<>();
        while (!queue.isEmpty()){
            List<ListNode> treeNodes=new ArrayList<>();
            int parentSize=queue.size();
            ListNode root=new ListNode(-1);
            ListNode next=root;
            for(int i = 0 ; i< parentSize;i++){
                TreeNode parent=queue.poll();
                next.next=new ListNode(parent.val);
                next=next.next;
                if(parent.left!=null){
                    queue.add(parent.left);
                }
                if(parent.right!=null){
                    queue.add(parent.right);
                }
            }
            res.add(root.next);

        }

//        ListNode[] result=new ListNode[res.size()];
//
//        for(int i = 0 ; i< res.size();i++){
//            result[i]=res.get(i);
//        }

        return res.toArray(new ListNode[0]);

    }


    public ListNode[] listOfDepth_V1(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();
        if (tree == null)
            return new ListNode[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummyHead = new ListNode(-1), tail = dummyHead;
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                tail.next = new ListNode(tn.val);
                tail = tail.next;
                if (tn.left != null)
                    queue.add(tn.left);
                if (tn.right != null)
                    queue.add(tn.right);
            }
            res.add(dummyHead.next);
        }
        return res.toArray(new ListNode[0]);
    }

   public static void main(String args[]){
        TreeNode treeNode=TreeNode.generateTree();
        TreeLevelList_Interview0403 treeLevelList_interview0403=new TreeLevelList_Interview0403();
        treeLevelList_interview0403.listOfDepth(treeNode);
   }

}
