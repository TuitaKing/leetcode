package com.tuitaking.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDepth_111 {

    public int minDepth(TreeNode root) {
        int depth = 1;
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        while (nodeDeque.size() > 0) {
           int currentSize=nodeDeque.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode cur = nodeDeque.poll();
                if (TreeUtils.isLeaf(cur)) {
                    return depth;
                }
                if (cur.left != null) {
                    nodeDeque.add(cur.left);
                }
                if (cur.right != null) {
                    nodeDeque.add(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node=TreeUtils.generateArrayToTree(new Integer[]{1,2,3,4,null,null,5});
        MinDepth_111 minDepth_111=new MinDepth_111();
        minDepth_111.minDepth(node);
    }

}
