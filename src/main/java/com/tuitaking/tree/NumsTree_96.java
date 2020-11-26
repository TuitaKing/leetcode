package com.tuitaking.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumsTree_96 {

   static Map<String,Integer> maps=new HashMap<>();
    public static int binary_tree_count(int low,int high){
        if(low == high || (low > high)){
            return 1;
        }
        int result = 0;
        for (int i = low;i <= high;i++){
            int lresult=0;
            if(maps.get(low+"_"+(i-1))!=null){
                lresult=maps.get(low+"_"+(i-1));
            }else {
                lresult = binary_tree_count(low,i-1);
                maps.put(low+"_"+(i-1),lresult);
            }
            int rresult=0;
            if(maps.get((i+1)+"_"+high)!=null){
                rresult=maps.get((i+1)+"_"+high);
            }else {
                rresult = binary_tree_count(i+1,high);
                maps.put((i+1)+"_"+high,rresult);
            }

            result = result + (lresult * rresult);
        }
        return result;
    }
    public static int numTrees(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int lresult = binary_tree_count(1,i-1);
            maps.put("1"+"_"+(i-1),lresult);
            int rresult = binary_tree_count(i+1,n);
            maps.put((i+1)+"_"+n,rresult);
            result = result + (lresult * rresult);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }



    Deque<TreeNode> treeNodes=new ArrayDeque<>();

    public void flatten(TreeNode root) {

        TreeNode right=root;
        root.left=null;
        pre(root);
        treeNodes.poll();
        for(TreeNode node:treeNodes){
            node.left=null;
            right.right=node;
            right=right.right;
        }

    }
    public void pre(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode top = stack.poll();
            System.out.println(top.val);
            treeNodes.add(top); //处理的函数
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

//    public static void main(String[] args) {
//        TreeNode treeNode=TreeUtils.generateArrayToTree(new Integer[]{1,2,5,3,4,null,6});
//        NumsTree_96 numsTree_96=new NumsTree_96();
//        numsTree_96.flatten(treeNode);
//        System.out.println("hello");
//    }
}
