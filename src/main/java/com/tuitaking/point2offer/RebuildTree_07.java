package com.tuitaking.point2offer;

import com.tuitaking.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RebuildTree_07 {
//    Map<Integer,Integer> inorderMaps=new HashMap<>();
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(preorder.length==0 || inorder.length==0){
//            return null;
//        }
//        for(int i = 0 ;i< inorder.length;i++){
//            inorderMaps.put(inorder[i],i);
//        }
//
//    }
//
//    public TreeNode helper(int[] preorder, int[] inorder,int preLeft,int preRight,int inorderLeft,int inorderRight){
//        if(preLeft<preRight){
//            return null;
//        }
//        int currentLeft=inorderMaps.get(preorder[preLeft]);
//        int leftLength=currentLeft-inorderLeft;
//        TreeNode root=new TreeNode(preorder[preLeft]);
//    }
}
