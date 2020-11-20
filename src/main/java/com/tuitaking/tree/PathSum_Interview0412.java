package com.tuitaking.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。

 示例:
 给定如下二叉树，以及目标和 sum = 22，

  5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 返回:

 3
 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 https://leetcode-cn.com/problems/paths-with-sum-lcci/

 */
public class PathSum_Interview0412 {
    int res=0;
    int sum=0;
   // 此种解法无法通过测试[1,-2,3] 1，由于lists数组中包含了很多过往的路径。导致无法通过。
    public int pathSum(TreeNode root, int sum) {
//        int res=0;
        this.sum=sum;
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> pre=new ArrayList<>();
        pre.add(0);
        inner(root,list,pre);
        for(List<Integer> list1:list){
          for(int i = 1 ; i< list1.size();i++){
                  for (int j = 0; j < i; j++)
                      // sum of nums[j..i-1]
                      if (list1.get(i) - list1.get(j) == sum)
                          res++;
          }
        }
        return res;
    }

    public void inner(TreeNode root, List<List<Integer>> preSumList,List<Integer> pre){

        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            List<Integer> current=new ArrayList<>();
            current.addAll(pre);
            current.add(root.val+pre.get(pre.size()-1));
            preSumList.add(current);
            return;
        }
        if(root.val==sum){
            res++;
        }
        List<Integer> current=new ArrayList<>();
        current.addAll(pre);
        current.add(root.val+pre.get(pre.size()-1));
        inner(root.left,preSumList,current);
        inner(root.right,preSumList,current);
    }

    //暴力一点，计算所有的路径，如果为target，则返结果++
    public int pathSum_v2(TreeNode root, int sum) {
        if(root==null){
            return this.res;
        }
        sumHelper(root,sum);
        pathSum_v2(root.left,sum);
        pathSum_v2(root.right,sum);
        return this.res;
    }

    public void sumHelper(TreeNode root,int sum){
        if(root==null){
            return;
        }
        sum=sum-root.val;
        if(sum==0){
            this.res++;
        }
        sumHelper(root.left,sum);
        sumHelper(root.right,sum);
    }





    public static void main(String[] args) {
        TreeNode node=TreeUtils.generateArrayToTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        PathSum_Interview0412 pathSum_interview0412=new PathSum_Interview0412();
        System.out.println(pathSum_interview0412.pathSum_v2(node,22));
    }
}
