package com.tuitaking.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DelNode_1110 {
    HashMap<Integer, Integer> set = new HashMap<>();
    List<TreeNode> res=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) {
            set.put(i, i);
        }
       // res.add(root);
        helper(root);
        return res;
    }

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        if(root!=null && set.containsKey(root.val)){
            res.add(root.left);
            res.add(root.right);
            root.left=null;
            root.right=null;
        }
        helper(root.left);
        helper(root.right);

    }

    public static void main(String[] args) {
        TreeNode nodes=TreeUtils.generateArrayToTree(new Integer[]{1,2,3,4,5,6,7});
        DelNode_1110 delNode_1110=new DelNode_1110();
        delNode_1110.delNodes(nodes,new int[]{1,5});
        System.out.println("a");
    }
}
