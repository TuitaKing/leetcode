package com.tuitaking.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EraseOverlapIntervals_435 {
    // 该答案是找到所有重叠的区间,这道题目的关键应该是想明白，如果一个数组的最右边大于数组最左边，则说明肯定相交
    // 先将二维数组按照最后一位排序，然后比较当前最大的值时候比后面最小的值还小就可以解决
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==1){
            return 0;
        }
        int res=0;
        // 将数组按照生序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[o1.length-1]>o2[o2.length-1]){
                    return 1;
                }
                return -1;
            }
        });
        int current=Integer.MIN_VALUE;
        for(int i = 0 ; i < intervals.length;i++){
            if(intervals[i][0]<current){
                res++;
            }else {
                current=intervals[i][intervals[i].length-1];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(EraseOverlapIntervals_435.eraseOverlapIntervals(new int[][]{ {1,2}, {2,3}, {3,4}, {1,3} }));
    }
}
