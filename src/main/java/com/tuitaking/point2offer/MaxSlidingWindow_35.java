package com.tuitaking.point2offer;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow_35 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<int[]>(k,(a,b)-> b[0]-a[0]);
        int[] res=new int[nums.length-k+1];
        int index=0;
        for(int i = 0 ; i <nums.length;i++) {
            queue.offer(new int[]{nums[i], i});
            while (!queue.isEmpty() && i - queue.peek()[1] > k-1) {
                queue.poll();
            }
            if (i >= k-1) {
                res[index] = queue.peek()[0];
                index++;
            }
        }
        return res;
    }

    public int[] maxSlidingWindow_offer(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        LinkedList<Integer> integers=new LinkedList<>();
        integers.addLast(0);
        for(int i = 1 ; i<nums.length;i++){
            while (i-integers.peek()>=k){
                integers.pollLast();
            }
            if(nums[integers.peek()]<nums[i]){
                integers.addLast(i);
            }
        }
        return res;
    }
}
