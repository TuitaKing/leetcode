package com.tuitaking.point2offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search_53_1 {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int start=0,end=nums.length;
        int mid=0;
        boolean find=false;
        while (start<end){
            mid=(end-start)/2+start;
            if(nums[mid]>target){
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else {
                find=true;
                break;
            }
        }
        int count=0;
        if(find){
            int toLeft=mid;
            int toRight=mid+1;
            while (toLeft>=0){
                if(nums[toLeft]==target){
                    count++;
                    toLeft--;
                }else {
                    break;
                }
            }
            while (toRight<nums.length){
                if(nums[toRight]==target){
                    count++;
                    toRight++;
                }else {
                    break;
                }
            }
        }else {
            return count;
        }
        return count;

    }

    // todo 如何确定二分是左边界还是右边界
    public int search_v1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

}
