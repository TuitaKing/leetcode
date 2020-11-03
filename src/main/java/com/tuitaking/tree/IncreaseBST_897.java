package com.tuitaking.tree;

import com.tuitaking.binary_search_algorithm.Intersect_350;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 将数组实现为二叉树 [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 * <p>5 / \ 3 6 / \ \ 2 4 8 / / \ 1 7 9
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IncreaseBST_897 {
  // 按照中序遍历二叉树
  public TreeNode increasingBST(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<TreeNode> list = new ArrayList<>();
    innerBST(root, list);
    TreeNode res = new TreeNode(-1);
    TreeNode right = res;
    for (TreeNode node : list) {
      node.left = null;
      node.right = null;
      right.left = null;
      right.right = node;
      right = right.right;
    }
    return res.right;
  }

  public void innerBST(TreeNode treeNode, List<TreeNode> res) {
    if (treeNode == null) {
      return;
    }
    innerBST(treeNode.left, res);
    res.add(treeNode);
    innerBST(treeNode.right, res);
  }

  public TreeNode increasingBST_withLoop(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode tmp = new TreeNode(-1);
    TreeNode res = tmp;
    // List<TreeNode> treeNodes=new ArrayList<>();

    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.poll();
      res.right = new TreeNode(node.val);
      res = res.right;
      //          treeNodes.add(node);
      node = node.right;
    }
    return tmp.right;
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        TreeUtils.generateArrayToTree(
            new Integer[] {5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9});
    IncreaseBST_897 increaseBST_897 = new IncreaseBST_897();
    increaseBST_897.increasingBST_withLoop(treeNode);
  }
}
