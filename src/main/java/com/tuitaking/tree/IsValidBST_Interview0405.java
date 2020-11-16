package com.tuitaking.tree;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST_Interview0405 {
    //此等递归是不行的，由于可能存在孙子节点本应在祖父节点的左边，却在祖父节点右子树上做左子树，这种也不是二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left!=null){
           if(root.left.val>=root.val){
               return false;
           }
        }
        if(root.right!=null){
            if( root.right.val<=root.val){
                return false;
            }
        }
        return isValidBST(root.left)&&isValidBST(root.right);
    }


    // 暴力解法，一个一个对比
    public boolean isValidBST_v2(TreeNode root) {

        if(root==null){
            return true;
        }

        return (innerLeft(root.left,root,true)&&innerLeft(root.right,root,false))&&isValidBST_v2(root.left)&&isValidBST_v2(root.right);

    }


   public boolean innerLeft(TreeNode root,TreeNode current,boolean left){
        if(root==null){
            return true;
        }
        if(left){
            if(root.val>=current.val){
                return false;
            }
        }else {
            if(root.val<=current.val){
                return false;
            }
        }

       return innerLeft(root.left,current,left)&&innerLeft(root.right,current,left);
   }


    TreeNode pre;
    //中序遍历
    public boolean isValidBST_v3(TreeNode root) {
        if(root == null) {
            return true;
        }
        Boolean LFlag = isValidBST_v3(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        Boolean RFlag = isValidBST_v3(root.right);
        return LFlag & RFlag;
    }

    public static void main(String[] args) {
        TreeNode treeNode=TreeUtils.generateArrayToTree(new Integer[]{5,1,7,null,null,6,8});
        System.out.println(new IsValidBST_Interview0405().isValidBST_v3(treeNode));
    }


}
