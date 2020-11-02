package com.tuitaking.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder_offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return Collections.emptyList();
        }
        List<List<Integer>> res=new ArrayList<>();
        inner(root,0,res);
        return res;

    }
    public void inner(TreeNode  treeNode,int depth,List<List<Integer>> res){
        if(treeNode==null){
            return;
        }
        if(res.size()==depth){
//            List<Integer> list=new ArrayList<>();
//            list.add(treeNode.val);
//            res.add(depth,list);
            res.add(new ArrayList<>());
        }
//        else {
//            List<Integer> currentlevel=res.get(depth);
//            currentlevel.add(treeNode.val);
//        }
        res.get(depth).add(treeNode.val);
        inner(treeNode.left,depth+1,res);
        inner(treeNode.right,depth+1,res);
    }

    public static void main(String[] args) {
        TreeNode node=TreeNode.generateTree();
        LevelOrder_offer32 levelOrder_offer32=new LevelOrder_offer32();
        List<List<Integer>> res=levelOrder_offer32.levelOrder(node);
        System.out.println(res);

    }
}
