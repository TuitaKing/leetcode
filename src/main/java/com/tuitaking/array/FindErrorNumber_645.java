package com.tuitaking.array;

/**
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 * <p>
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindErrorNumber_645 {
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        int[] temp = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i]] != -1) {
                temp[nums[i]] = -1;
            } else {
                res[0] = nums[i];
            }
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                res[1] = i ;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = FindErrorNumber_645.findErrorNums(new int[]{3,3,1});
        System.out.println("a");
    }
}
