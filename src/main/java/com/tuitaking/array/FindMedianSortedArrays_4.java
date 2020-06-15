package com.tuitaking.array;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *  
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保nums1的长度始终小于nums2
        if(nums1.length>nums2.length){
            findMedianSortedArrays(nums2,nums1);
        }
        int num1Length=nums1.length;
        int num2Length=nums2.length;

        int totalLeft=(num2Length+num1Length)/2;
        // 在小的数组中查找
        int left=0;
        int right=num1Length;

        // 需要保证的是在数组1中的i的值比数组2中的j的右边的数小，即 nums1[i]<nums2[j+1]
        while (left<right){
            int i=left+(right-left+1)/2; // 此处为二分的地方，保证时间复杂度O(log(m+n))
            int j=totalLeft-i;
            if(nums1[i-1]>nums2[j]){
                right=i-1;
            }else {
                left=i;
            }
        }
        int i = left;
        int j =totalLeft-i;
        int nums1LeftMax=i==0?Integer.MIN_VALUE:nums1[left-1];
        int nums1RightMin=i==num1Length?Integer.MAX_VALUE:nums1[i];
        int nums2LeftMax=j==0?Integer.MIN_VALUE:nums2[j-1];
        int nums2RightMin=j==num2Length?Integer.MIN_VALUE:nums2[j];
        if((num1Length+num2Length)/2==1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        }else {
            return (Math.max(nums1LeftMax,nums2LeftMax)+Math.min(nums1RightMin,nums2RightMin))/2.0;
        }
    }
}
/**
 * 找到中位数，如果是奇数个数据，则找到中间数，如果是偶数，则是中间两个数只和除以二
 * 按照这个思路，在两个有序的数组中找到中位数，可以将两个数组分为两堆，左边一堆的最大值小于右边一堆的最小值
 *
 */
