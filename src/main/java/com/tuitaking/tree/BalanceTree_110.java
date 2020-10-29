package com.tuitaking.tree;


/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。Tre
 */
public class BalanceTree_110 {
    public boolean isBalanced(TreeNode root) {
       if(root==null){
           return true;
       }
       return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

    public int innerHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

   // 题目中的要求是每一个节点都需要满足他的节点左右相差不超过1。所以从底部向上遍历，后序遍历
    // 左右树之差不超过1，则说明是平衡，反之不平衡，如何将子节点的数据向上传递呢
    public int treeHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=treeHeight(root.left);
        int right=treeHeight(root.right);
        // -1 表示为子节点不是平衡节点
        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        // 如果子节点都是平衡节点，则计算当前节点的高度
        return Math.max(left,right)+1;

    }

    public boolean isBalance_v2(TreeNode root){
        return treeHeight(root)>-1;
    }

    public static void main(String[] args) {
        BalanceTree_110 balanceTree_110=new BalanceTree_110();
        boolean a= balanceTree_110.isBalance_v2(TreeNode.generateTree());
        System.out.println(a);
    }
}
