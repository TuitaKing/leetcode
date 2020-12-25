package com.tuitaking.point2offer;

import com.tuitaking.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum_34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        helper(root,sum,result,new LinkedList<>());
        return result;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> curr) {
            if(root==null){
                return;
            }
            if(root.left==null && root.right==null){
                if((sum- root.val)==0) {
                    List<Integer> tmp = new ArrayList<>();
                    for (Integer integer : curr) {
                        tmp.add(integer);
                    }
                    tmp.add(root.val);
                    res.add(tmp);
                }
                return;
            }
            curr.addLast(root.val);
            helper(root.left,(sum-root.val),res,curr);
            helper(root.right,(sum-root.val),res,curr);
            curr.removeLast();
    }
}
