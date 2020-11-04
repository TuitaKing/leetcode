package com.tuitaking.tree;

/**
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class CountNodeTree_222 {
    //在一颗二叉树中，若除最后一层外的其余层都是满的，并且最后一层要么是满的，要么在右边缺少连续若干节点，则此二叉树为完全二叉树
    public int countNodes(TreeNode root) {
         return count(root);
    }
    public int count(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftCount=count(node.left);
        int rightCount=count(node.right);
        return leftCount+rightCount+1;
    }

    public static void main(String[] args) {
        TreeNode node=  TreeUtils.generateArrayToTree(
                new Integer[] {5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9});
        CountNodeTree_222 countNodeTree_222=new CountNodeTree_222();
        System.out.println(countNodeTree_222.countNodes(node));
    }
}
