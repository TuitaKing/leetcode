package com.tuitaking.tree;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * 通过次数18,555提交次数33,562
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TreeToString_606 {
    public String tree2str(TreeNode t) {
        if(t==null){
            return null;
        }
        StringBuilder res=helper(t,new StringBuilder());
        res.deleteCharAt(0);
        res.deleteCharAt(res.lastIndexOf(")"));
        return res.toString();
    }
    private StringBuilder helper(TreeNode root,StringBuilder sb){
        if(root==null){
            return sb;
        }
        sb.append("(");sb.append(root.val);
        if(root.left==null && root.right!=null){
            sb.append("()");
        }else{
            helper(root.left,sb);
        }
        helper(root.right,sb);
        sb.append(")");
        return sb;
    }

    public static void main(String[] args) {
        TreeNode node=TreeUtils.generateArrayToTree(new Integer[]{1,2,3,null,4});
        System.out.println(new TreeToString_606().tree2str(node));
    }
}
