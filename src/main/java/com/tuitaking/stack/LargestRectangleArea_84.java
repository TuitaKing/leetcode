package com.tuitaking.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为[2,1,5,6,2,3]。
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为10个单位。
 * 示例:
 * 输入: [2,1,5,6,2,3]
 *    [5,6]==5*2
 * 输出: 10
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleArea_84 {
    // sorry ,it's my stupid idea;
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        Deque<Integer> stack=new ArrayDeque<>();
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i = 0 ; i< heights.length;i++){
            min=Math.min(min,heights[i]);
            max=Math.max(max,heights[i]);
            if(stack.isEmpty()){
                stack.push(i);
            }else {
               if(heights[stack.peek()]<heights[i]){
                   max=Math.max(Math.min(heights[i],heights[stack.peek()])*(i-stack.peek()+1),max);
                   stack.push(i);
               }else {
                   while (!stack.isEmpty()){
                        int start=stack.pop();
                        max=Math.max(Math.min(heights[i],heights[start])*(i-start+1),max);
                   }
               }
            }
        }
        max= Math.max(min*heights.length,max);
        return max;
    }
    // 暴力
    public int largestRectangleArea_v1(int[] heights) {
        int max=0;
        for(int i = 0 ; i < heights.length;i++){
            int min=heights[i];
            for(int j = i ; j< heights.length;j++){
                min=Math.min(min,heights[j]);
                max=Math.max(min*(j-i+1),max);
            }
        }
       return max;
    }

    /**
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea_v2(int[] heights) {
        return 0;
    }

}
