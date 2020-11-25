package com.tuitaking.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RightSideView_199 {
    /**
     * 解法1的想法，就是按照当前的深度来，然后由左到右。
     */
    Map<TreeNode,Integer> depthMap=new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
            if(root==null){
                return Collections.emptyList();
            }
            int depth=depth(root,0);
            List<Integer> res=new ArrayList<>(depth);
            for(int i = 0 ;i< depth;i++){
                res.add(-1);
            }
            answer(root,res);
            return res;
    }

    public void answer(TreeNode root,List<Integer> res){
         if(root==null){
             return;
         }
         answer(root.left,res);
         answer(root.right,res);
         res.set(depthMap.get(root),root.val);
    }

    public int depth(TreeNode node,int depth){
        if(node==null){
            return depth;
        }
        depthMap.put(node,depth);
        int left=depth(node.left,depth+1);
        int right=depth(node.right,depth+1);
        return Math.max(left,right);
    }



    public List<Integer> rightSideView_v2(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        helper(root,res,0);
        return res;
    }
    public void helper(TreeNode root,List<Integer> res,int depth){
        if(root==null){
            return;
        }
      if(res.size()==depth){
          res.add(root.val);
      }
      helper(root.right,res,depth+1);
      helper(root.left,res,depth+1);
    }
    public static void main(String[] args) {
        TreeNode node=TreeUtils.generateArrayToTree(new Integer[]{1,2,3,null,5,null,4});
        RightSideView_199 rightSideView_199=new RightSideView_199();
        List<Integer> res=rightSideView_199.rightSideView_v2(node);
        System.out.println("hello");
    }
}
