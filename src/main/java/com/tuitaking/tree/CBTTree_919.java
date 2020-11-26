package com.tuitaking.tree;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 *
 * CBTInserter(TreeNode root)使用头节点为root的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *
 *
 * 示例 1：
 *
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * 示例 2：
 *
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 *
 * 提示：
 *
 * 最初给定的树是完全二叉树，且包含1到1000个节点。
 * 每个测试用例最多调用CBTInserter.insert操作10000次。
 * 给定节点或插入节点的每个值都在0到5000之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complete-binary-tree-inserter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CBTTree_919 {
    private TreeNode rootNode;
    public CBTTree_919(TreeNode root) {
        this.rootNode=root;
    }

    public int insert(int v) {
        if(rootNode==null){
            rootNode=new TreeNode(v);
        }
        List<List<TreeNode>> level=new ArrayList<>();
        helper(rootNode,level,0);

        if(level.size()>0){
            int depth=level.size();
            List<TreeNode> leafList=level.get(level.size()-1);
            List<TreeNode> parentList=null;
            if(level.size()<=1){
                parentList=level.get(0);
            }else {
                parentList=level.get(level.size()-2);
            }

            int leafSize=leafList.size();
            int nodes=(int)Math.pow(2,depth-1);
            TreeNode parent=rootNode;
            if(leafSize<nodes){
                parent=parentList.get(((leafSize)/2));
            }else if(leafSize==nodes){
                parent=leafList.get(0);
            }
            if(parent.left==null){
                parent.left=new TreeNode(v);
            }else if(parent.right==null){
                parent.right=new TreeNode(v);
            }
            return parent.val;
        }
        return 0;
    }
    private void helper(TreeNode node,List<List<TreeNode>> level,int depth){
        if(node==null){
            return;
        }
        if(level.size()==depth){
            level.add(new ArrayList<TreeNode>());
        }
        level.get(depth).add(node);
        helper(node.left,level,depth+1);
        helper(node.right,level,depth+1);
    }

    public TreeNode get_root() {
        return rootNode;
    }
    public static void main(String[] args) {
        TreeNode node=TreeUtils.generateArrayToTree(new Integer[]{1,2,3,4,5,6});
        CBTTree_919 cbtTree_919=new CBTTree_919(node);
        System.out.println(cbtTree_919.insert(7));
        System.out.println(cbtTree_919.insert(8));
        System.out.println(cbtTree_919.get_root().val);
    }
}
