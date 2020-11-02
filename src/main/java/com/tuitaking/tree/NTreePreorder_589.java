package com.tuitaking.tree;

import java.util.ArrayList;
import java.util.List;

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

}
