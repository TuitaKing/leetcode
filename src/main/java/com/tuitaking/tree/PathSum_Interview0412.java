package com.tuitaking.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    //官方最快解法
    public int pathSum_vTop1(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int h = dep(root);
        int[] paths = new int[h];
        res = 0;
        dfs(root,sum,paths,0);
        return res;
    }
    public int dep(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(dep(root.left),dep(root.right))+1;
    }
    public void dfs(TreeNode root,int sum, int[] paths, int level){
        if(root==null){
            return;
        }
        paths[level] = root.val;
        int add = 0;
        for(int i = level;i>=0;i--){
            add+=paths[i];
            if(add==sum){
                res++;
            }
        }
        dfs(root.left,sum,paths,level+1);
        dfs(root.right,sum,paths,level+1);
    }

    // 回溯 使用一个map来记录前缀和出现的次数
    private int count;
    private int target;
    private void backtrack(TreeNode root, Map<Long,Integer> preSum, long total){
        if(root==null){
            return;
        }
        total+=root.val;
        count+=preSum.getOrDefault(total-target,0); // 先统计前缀和,记录到root中
        preSum.put(total,preSum.getOrDefault(total,0)+1);// 将前缀和出现记录为1，表示当前的链路
        backtrack(root.left,preSum,total);
        backtrack(root.right,preSum,total);
        preSum.put(total,preSum.get(total)-1); //清楚当前前缀和出现的次数
        total-=root.val;
    }
    public int pathSum_vTop2(TreeNode root, int sum) {
        count=0;
        target=sum;
        Map<Long,Integer> preSum=new HashMap<>();
        preSum.put(0L,1); //base 等于0时加1
        backtrack(root,preSum,0L);
        return count;
    }

    public static void main(String[] args) {
        TreeNode node=TreeUtils.generateArrayToTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        PathSum_Interview0412 pathSum_interview0412=new PathSum_Interview0412();
        System.out.println(pathSum_interview0412.pathSum_v2(node,22));
    }
}
