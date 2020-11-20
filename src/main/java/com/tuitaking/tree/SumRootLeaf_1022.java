package com.tuitaking.tree;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 *
 * 输入：root = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：root = [1,1]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumRootLeaf_1022 {
    int res=0;
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        helper(root,sb);
        return res;
    }

    public void helper(TreeNode root,StringBuilder builder){
        if(root==null){
            return;
        }
        if( root.right==null && root.left==null){
            builder.append(root.val);
            res+=Integer.parseInt(builder.toString(), 2);
            builder.deleteCharAt(builder.length()-1);
            return;
        }

        builder.append(root.val);
        int cur=builder.length();
        helper(root.left,builder);
//        builder.deleteCharAt(cur-1);
        helper(root.right,builder);
        builder.deleteCharAt(cur-1);
    }


    public int sumRootToLeaf_v1(TreeNode node){
        if(node==null){
            return 0;
        }
        helper_v1(node,0);
        System.out.println(result);
        return result;
    }
    int result;

    public void helper_v1(TreeNode root,int res){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            result+=(res<<1)+root.val;
            return;
        }
        int current=(res<<1)+root.val;
        helper_v1(root.left,current);
        helper_v1(root.right,current);
    }


    public static void main(String[] args) {
        TreeNode node=TreeUtils.generateArrayToTree(new Integer[]{1,0,1,0,1,0,1});
        SumRootLeaf_1022 sumRootLeaf_1022=new SumRootLeaf_1022();
        sumRootLeaf_1022.sumRootToLeaf_v1(node);
    }
}
