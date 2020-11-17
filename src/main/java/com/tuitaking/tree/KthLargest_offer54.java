package com.tuitaking.tree;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargest_offer54 {

    TreeNode pre;
    Stack<TreeNode> stack=new Stack<>();
    public int kthLargest(TreeNode root, int k) {
        if(root==null){
            return 1;
        }
        largest_helper(root,k-1);
        return stack.peek().val;
    }

    public void largest_helper(TreeNode root,int k){
        if(root==null){
            return;
        }
        largest_helper(root.right,k);

        if(stack.size()<=k){
            stack.add(root);
        }else {
            return;
        }
        pre=root;
        largest_helper(root.left,k);
    }


    int k;
    int res;
    public int kthLargest_v1(TreeNode root, int k){
        this.k=k;
        helper(root);
        return res;
    }

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.right);
        if(--k==0){
            res=root.val;
        }
        helper(root.left);

    }

    public static void main(String[] args) {
        TreeNode root=TreeUtils.generateArrayToTree(new Integer[]{5,3,6,2,4,null,null,1});
        KthLargest_offer54 kthLargest_offer54=new KthLargest_offer54();
        System.out.println(kthLargest_offer54.kthLargest_v1(root,6));
    }
}
