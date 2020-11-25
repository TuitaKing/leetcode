package com.tuitaking.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumsTree_96 {
    Deque<TreeNode> treeNodes=new ArrayDeque<>();

    public void flatten(TreeNode root) {

        TreeNode right=root;
        root.left=null;
        pre(root);
        treeNodes.poll();
        for(TreeNode node:treeNodes){
            node.left=null;
            right.right=node;
            right=right.right;
        }

    }
    public void pre(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode top = stack.poll();
            System.out.println(top.val);
            treeNodes.add(top); //处理的函数
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode=TreeUtils.generateArrayToTree(new Integer[]{1,2,5,3,4,null,6});
        NumsTree_96 numsTree_96=new NumsTree_96();
        numsTree_96.flatten(treeNode);
        System.out.println("hello");
    }
}
