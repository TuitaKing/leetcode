package com.tuitaking.everyDay;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 示例1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Candy_135 {
    /**
     * 如果当前比左右都小，则获取1个糖果，
     * 如果当前比左边大，比右边小，则在左边的加1
     * 如果当前比左边小，比右边大，则获取两个
     * [36, 68, 52, 31]
     * 如果连续递减，那么第一个需要连续递减区间的多大的那个
     * @param ratings
     * @return
     */
    public int candy_my(int[] ratings) {
        if(ratings.length<=1){
            return 1;
        }
        int res=0;
        int[] dp=new int[ratings.length];
        dp[0]=1;
        if(ratings.length>1){
            if(dp[0]>dp[1]){
                dp[0]=2;
            }
        }
        for(int i = 1 ; i<ratings.length;i++){
            if(i==ratings.length-1){
                if(ratings[i]>ratings[i-1]){
                    dp[i]=dp[i-1]+1;
                }else {
                    dp[i]=1;
                }
                break;
            }
            // 当前比左边大，比右边小
            if(ratings[i]>ratings[i-1]&&ratings[i]<ratings[i+1]){
                dp[i]=dp[i-1]+1;
            }
            //比左边小，比右边小
            if(ratings[i]<=ratings[i-1]&&ratings[i]<ratings[i+1]){
                dp[i]=2;
            }
            // 比左右都大
            if(ratings[i]>ratings[i-1]&&ratings[i]>ratings[i+1]){
                dp[i]=dp[i-1]+1;
            }
            // 比左右都小
            if(ratings[i]<=ratings[i-1]&&ratings[i]<=ratings[i+1]){
                dp[i]=1;
            }
        }
        for(int i : dp){
            if(i==0){
                res+=1;
            }
            res+=i;
        }
        return res;
    }

    // 从左往右找最小的值，给他1个，然后累加到最大的那个位置，1+2+n
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;

    }

    public int candy_v1(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}
