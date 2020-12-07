package com.tuitaking.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trap_Interview1721 {

    // 本来想使用栈，但是发现不好计算其实
    public int trap(int[] height) {
        int left=0,right=height.length-1;
        int leftMax=0,rightMax=0;
        int res=0;
        while (left<right){
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax=height[left];
                }else {
                    res+=leftMax-height[left];
                }
                left++;
            }else {
                if(height[right]>rightMax){
                    rightMax=height[right];
                }else {
                    res+=rightMax-height[right];
                }
                right--;
            }

        }
        return res;
    }


    public int trap_stack_v1(int[] height){
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;

    }

    public static void main(String[] args) {
        Trap_Interview1721 trap_interview1721=new Trap_Interview1721();
        System.out.println(trap_interview1721.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap_interview1721.trap_stack_v1(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
