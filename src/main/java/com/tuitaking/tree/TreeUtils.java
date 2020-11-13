package com.tuitaking.tree;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.*;


public class TreeUtils {

  public static  TreeNode generateArrayToTree(Integer[] value){
    TreeNode p = new TreeNode(value[0]);
    TreeNode q = p;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    int i=0;
    while (p!=null){
      if(2*i+1<value.length){
        if(value[2*i+1]!=null){
          p.left = new TreeNode(value[2*i+1]);
          queue.add(p.left);
        }else {
          p.left=null;
        }
      }
      if (2*i+2<value.length){
        if(value[2*i+2]!=null){
          p.right = new TreeNode(value[2*i+2]);
          queue.add(p.right);
        }else {
          p.right=null;
        }
      }
      p = queue.poll();
      i+=1;
    }
    return q;
  }


  public static List<Integer> TreeNode2IntegerArray(TreeNode root){
    List<Integer> arrays=new ArrayList<>();
    return arrays;

  }




}
