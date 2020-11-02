package com.tuitaking.tree;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 将数组实现为二叉树
 * [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
        5
      /   \
     3     6
    / \     \
   2    4     8
  /          / \
 1          7   9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayToBinaryTree {

  public static  TreeNode generateArrayToTree(Integer[] value){
    TreeNode p = new TreeNode(value[0]);
    TreeNode q = p;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    int i=0;
    while (p!=null){
      if(2*i+1<value.length){
        p.left = new TreeNode(value[2*i+1]);
        queue.add(p.left);
      }
      if (2*i+2<value.length){
        p.right = new TreeNode(value[2*i+2]);
        queue.add(p.right);
      }
      p = queue.poll();
      i+=1;
    }
    return q;
  }




}
