package com.tuitaking.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 *
 */
public class NTreePreorder_589 {

    public List<Integer> preorder(Node root) {
    List<Integer> res=new ArrayList<>();
    innerPre(root,res);
    return res;
    }
    public void innerPre(Node root,List<Integer> pre){
        if(root==null){
            return;
        }
        pre.add(root.val);
       for(Node child:root.children){
           innerPre(child,pre);
       }
    }

    public List<Integer> innerPreWithLoop(Node root){
        Deque<Node> stack = new ArrayDeque<Node>();
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return Collections.emptyList();
        }
        stack.addFirst(root);
        while (!stack.isEmpty()){
            Node node=stack.pollLast();
            res.add(node.val);
            if(node.children!=null){
                for(int  i = node.children.size()-1 ; i>-1 ;i--){
                    stack.add(node.children.get(i));
                }
            }
        }
        return res;
    }

}
