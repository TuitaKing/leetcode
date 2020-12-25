package com.tuitaking.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 *
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/submissions/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagLevelOrder_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
           return Collections.emptyList();
        }
       // Deque<TreeNode> treeNodes=new ArrayDeque<>();
        LinkedList<TreeNode> treeNodes=new LinkedList<>(); // linked 会比array 快很多
        treeNodes.add(root);
        List<List<Integer>> res=new ArrayList<>();
        boolean left=true;
        while (!treeNodes.isEmpty()){
            List<Integer> list=new LinkedList<>();
            int level=treeNodes.size();
            TreeNode node ;
            for (int i = 0 ; i<level;i++){
                    node=treeNodes.poll();
                    if(node!=null){
                        if(left){
                            list.add(node.val);
                        }else {
                            list.add(0,node.val);
                        }
                        if(node.left!=null){
                            treeNodes.add(node.left);
                        }
                        if(node.right!=null){
                            treeNodes.add(node.right);
                        }
                    }

            }
            left=!left;
            res.add(list);
        }
        return res;
    }
    public List<List<Integer>> zigzagLevelOrder_v1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root,res,0);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }
        if((level & 1) == 1){
            //如果level是奇数，其实实际上层数是偶数，那么应该已经是从右往左了
            res.get(level).add(0,root.val);
        }else{
            res.get(level).add(root.val);
        }
        traversal(root.left,res,level + 1);
        traversal(root.right,res,level + 1);
    }
}
