package com.tuitaking.array;
/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。


说明：你不能倾斜容器，且 n 的值至少为 2。
示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxWaterArea_11 {
    public static void main(String[] args) {
        int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        MaxWaterArea_11 maxWaterArea_11=new MaxWaterArea_11();
        System.out.println(maxWaterArea_11.maxArea(height));
    }
    // 求得是最大容水量，设s[i,j]为i,j之间的容水量，容量面积取决于min(height[i],height[j])*(j-i)
    // 由于每次移动i，j都会导致宽度变小，但是已经记录了原来宽度的最大容水面积。所以，每次只需要移动短板的高度
    // 在高度带来的容量增加上找到最大面积 PS:感觉没有解释的很清楚，不知道是不是自己没有彻底搞懂
    public int maxArea(int[] height) {
        if(height.length<2){
            return 0;
        }
        if(height.length==2){
            return Math.min(height[0],height[1]);
        }
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<right){
            maxArea=Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
            if(height[left]>=height[right]){
                right--;
            }else {
                left++;
            }
        }
        return maxArea;
    }
}
