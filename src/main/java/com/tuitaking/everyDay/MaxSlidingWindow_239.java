package com.tuitaking.everyDay;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow_239 {
    // 超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return nums;
        }
        if(nums.length<k){
            int max=Integer.MIN_VALUE;
            for(int temp:nums){
                max=Math.max(max,temp);
            }
            return new int[]{max};
        }
        int[] res=new int[nums.length-k+1];
        int index=0;
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>(k,(a,b)->b-a);
        Queue<Integer> queue=new LinkedList<>();
        for(int n:nums){
            priorityQueue.offer(n);
            queue.add(n);
            if(queue.size()==k){
                res[index]=priorityQueue.peek();
                priorityQueue.remove(queue.poll());

            }
        }
        return res;
    }


    public int[] maxSlidingWindow_v(int[] nums, int k) {
        LinkedList<Integer> queue=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        for(int i = 0 ; i< nums.length;i++){
            while (!queue.isEmpty()&&nums[queue.peek()]<=nums[i]){
                queue.pollLast();
            }
            queue.addLast(nums[i]);
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                res[i+1-k] = nums[queue.peek()];
            }
        }
        return res;
    }

}
