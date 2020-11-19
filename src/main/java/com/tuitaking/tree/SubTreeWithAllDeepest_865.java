package com.tuitaking.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 *
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 *
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 *
 * 返回能满足 以该节点为根的子树中包含所有最深的节点 这一条件的具有最大深度的节点。
 * 注意：本题与力扣 1123 重复：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * 我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点。
 * 示例 3：
 *
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。
 *
 *
 * 提示：
 *
 * 树中节点的数量介于1 和500 之间。
 * 0 <= Node.val <= 500
 * 每个节点的值都是独一无二的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 题目翻译：查找最深的节点，如果该深度只有当前一个节点，就返回这个节点，如果有多个节点在同一个深度，就返回他们的公共祖先
 *
 * LCA？？？？
 */
public class SubTreeWithAllDeepest_865 {

    /**
     * 果然是异想天开的想法，如果深度为1的话是能够找到的，但是公共祖节点的深度大于1就不能查到了
     * @param root
     * @return
     */
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {

        Deque<TreeNode> treeNodes=new ArrayDeque<>();
        List<List<TreeNode>> lists=new ArrayList<>();
        treeNodes.offer(root);
        while (treeNodes.size()>0){
            int parentSize=treeNodes.size();
            List<TreeNode> level=new ArrayList<>();
            for(int i = 0 ; i< parentSize;i++){
                TreeNode current=treeNodes.poll();
                level.add(current);
                if(current.left!=null){
                    treeNodes.offer(current.left);
                }
                if(current.right!=null){
                    treeNodes.offer(current.right);
                }
            }
            lists.add(level);
        }
        if(lists.size()<=2){
            return root;
        }
        List<TreeNode> depthestParent=lists.get(lists.size()-2);

        for(TreeNode node:depthestParent){
            if(lists.get(lists.size()-1).size()==1){
//                if(node.left==lists.get(lists.size()-1).get(0)||node.right==lists.get(lists.size()-1).get(0)){
//                    return node;
//                }
                return lists.get(lists.size()-1).get(0);
            }
           if(node.left==lists.get(lists.size()-1).get(0) && node.right==lists.get(lists.size()-1).get(1)){
                return node;
           }
        }
        return null;
    }


    public TreeNode subtreeWithAllDeepest_v2(TreeNode root){
        if(root==null ){
            return root;
        }
        HashMap<TreeNode,Integer> depth=new HashMap<>();
        getDepth(root,null,depth);
        int maxDepth=0;
        for(TreeNode node:depth.keySet()){
            maxDepth=Math.max(depth.get(node),maxDepth);
        }
        TreeNode res=answer(root,depth,maxDepth);
        return res;

    }
    // 深度优先遍历，找到包含最深的祖父节点
    public TreeNode answer(TreeNode node,HashMap<TreeNode,Integer> depth,int max_depth) {
        if (node == null || depth.get(node) == max_depth)
            return node;
        TreeNode L = answer(node.left,depth,max_depth),
                R = answer(node.right,depth,max_depth);
        if (L != null && R != null) return node;
        if (L != null) return L;
        if (R != null) return R;
        return null;
    }



    private void getDepth(TreeNode root,TreeNode parent,Map<TreeNode,Integer> depth){
        if(root==null){
            return;
        }
        if(parent==null){
            depth.put(root,1);
        }else {
            depth.put(root,depth.get(parent)+1);
        }

        getDepth(root.left,root,depth);
        getDepth(root.right,root,depth);
    }

    public static void main(String[] args) {
//        TreeNode treeNode=TreeUtils.generateArrayToTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4,null,null,null,null,null,null,null,13,10,null});
        TreeNode treeNode=TreeUtils.generateArrayToTree(new Integer[]{0,1,3,null,2});
//        TreeNode treeNodes=  SubTreeWithAllDeepest_865.subtreeWithAllDeepest(treeNode);
        SubTreeWithAllDeepest_865 subTreeWithAllDeepest_865=new SubTreeWithAllDeepest_865();
        subTreeWithAllDeepest_865.subtreeWithAllDeepest_v2(treeNode);
    }
}
