package com.tuitaking.array;

/**
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 *
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 *
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * 用这个程序你能收集的水果总量是多少？
 *示例 1：
 *
 * 输入：[1,2,1]
 * 输出：3
 * 解释：我们可以收集 [1,2,1]。
 * 示例 2：
 *
 * 输入：[0,1,2,2]
 * 输出：3
 * 解释：我们可以收集 [1,2,2].
 * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
 * 示例 3：
 *
 * 输入：[1,2,3,2,2]
 * 输出：4
 * 解释：我们可以收集 [2,3,2,2].
 * 如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
 * 示例 4：
 *
 * 输入：[3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：我们可以收集 [1,2,1,1,2].
 * 如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 个水果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fruit-into-baskets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  
 * 这道题有点鬼扯，其实就是有两个篮子，每个篮子必须值装一种类型的数据，问能够装到的只有两个数组的最长序列
 *
 */
public class TotalFruit_904 {

    public int totalFruit(int[] tree) {
        if(tree.length<3){
            return tree.length;
        }
        int one=tree[0];
        int two=-1;
        int left=0;
        int right=0;
        while (right<tree.length){
            if(tree[right]==tree[left]){
                right++;
            }else {
                two=tree[right];
                break;
            }
        }
        int res=right<tree.length?right-left+1:tree.length;

        for (int i = right+1; i < tree.length; i++) {
            if(one!=tree[i]&&two!=tree[i]){
                left=right;
                while (tree[--left]==tree[i-1]){
                }
                right=i;
                left++;
                one=tree[i-1];
                two=tree[i];
            }
            else {
                res=Math.max(res,i-left+1);
                right++;
            }
        }
        return res;
    }



    public int totalFruit_v1(int[] tree) {
        if(tree.length<=2){
            return tree.length;
        }

        //left right 代表两种水果最后出现的坐标
        int left = -1;
        int right = 0;
        int res=2;

        int count = 1;
        for(int i=1 ; i<tree.length ; i++){
            //当前值和right对应的水果相同，没有出现第三个水果，更新right的值
            if(tree[i]==tree[right]){
                right = i;
                ++count;
            } else{
                //如果left还未赋值，或者当前值还在两种水果之内，没有出现第三种水果，更新right和left的值
                if(left<0 || tree[left]==tree[i]){
                    left = right;
                    right=i;
                    ++count;
                }
                //出现了第三种水果，要保证连续数组内只有两种，只能舍弃left
                else{
                    res = Math.max(count,res);
                    count = i-left;
                    left = right;
                    right = i;

                }
            }

        }

        res = Math.max(count,res);

        return res;

    }
}
