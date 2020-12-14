package com.tuitaking.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int preSum=nums[0],pre=0;
        for(int i :nums){
            pre=Math.max(i,pre+i);
            preSum=Math.max(preSum,pre);
        }
        return preSum;
    }

    public int maxSubArray_v1(int[] nums){
        if(nums==null){
            return 0;
        }
        int sum=0,max=nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            if(sum>0){
                sum+=nums[i];
            }else {
                sum=nums[i];
            }
            max=Math.max(sum,max);
        }
        return max;
    }

    public int maxSubArray_v2(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int[] preSum=new int[nums.length];
        preSum[0]=nums[0];
        int min=Math.min(preSum[0],0);
        int max=0;
        for(int i=1;i<nums.length;i++){
            preSum[i]=nums[i]+preSum[i-1];
            max=Math.max(preSum[i]-min,max);
            min=Math.min(min,preSum[i]);
        }
        return max;
    }

    public int maxSubArray_pre(int[] nums) {
        int len = nums.length;
        int[] pf = new int[len+1];
        for(int i = 1; i < len+1; i++) {
            pf[i] = nums[i-1] + pf[i-1];

        }
        int min = Math.min(nums[0], 0);
        // int mind = 0;
        int ans = nums[0];
        for(int i = 1; i < len; i++) {
            int pfs = pf[i+1] - min;
            ans = Math.max(ans, pfs);
            if(pf[i+1] < min) min = pf[i+1];

        }
        return ans;
    }
}
