package com.tuitaking.tree;

import com.tuitaking.binary_search_algorithm.Intersect_350;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 将数组实现为二叉树
 * [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
      5
    /   \
   3     6
  / \     \
 2   4     8
 /        / \
 1      7   9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IncreaseBST_897 {
  // 按照中序遍历二叉树
  public TreeNode increasingBST(TreeNode root) {
    if(root==null){
        return null;
    }
    List<TreeNode> list=new ArrayList<>();
    innerBST(root,list);
    TreeNode res=new TreeNode(-1);
    TreeNode right=res;
    for(TreeNode node:list){
        node.left=null;
        node.right=null;
        right.left=null;
        right.right=node;
        right=right.right;
    }
      return res.right;
  }

  public void innerBST(TreeNode treeNode, List<TreeNode> res){
        if(treeNode==null){
            return;
        }
        innerBST(treeNode.left, res);
        res.add(treeNode);
        innerBST(treeNode.right,res);
  }

  public static void main(String[] args) {
   TreeNode treeNode= TreeUtils.generateArrayToTree(new Integer[]{5,3,6,2,4,null,8,1,null,null,null,7,9});
   IncreaseBST_897 increaseBST_897=new IncreaseBST_897();
   increaseBST_897.increasingBST(treeNode);
  }
}
