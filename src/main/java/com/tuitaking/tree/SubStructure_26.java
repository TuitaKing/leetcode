package com.tuitaking.tree;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubStructure_26 {

//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        return isSubstructure()
//    }

    public  static boolean isSubstructure(TreeNode root,TreeNode sub){
        if(sub==null){
            return true;
        }
        if(root==null || root.val!=sub.val){
            return false;
        }
        return isSubstructure(root.left,sub.left)&&isSubstructure(root.right,sub.right);

    }

    public static void main(String[] args) {
        TreeNode node=  TreeUtils.generateArrayToTree(
                new Integer[] {5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9});
        TreeNode node1=  TreeUtils.generateArrayToTree(
                new Integer[] {5, 3, 6});

        System.out.println(isSubstructure(node,node1));
    }
}
