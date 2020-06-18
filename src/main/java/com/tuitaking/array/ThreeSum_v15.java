package com.tuitaking.array;

import com.tuitaking.dp.ClimbStairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lijing
 */
public class ThreeSum_v15 {
    public static void main(String[] args) {
        int[] data = new int[]{0,0,0,0,-1,1};
        ThreeSum_v15 threeSum_v15 = new ThreeSum_v15();
        List<List<Integer>> result = threeSum_v15.threeSum_v2(data, 0);
        System.out.println(result);
    }

    // 某些特殊的情况不能通过 {0,0,0,0}
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
//        是否有必要检验三个数的时候的情况
//        if (nums.length == 3) {
//            List<Integer> list = new ArrayList<>();
//            int sum=0;
//            for (Integer i : nums) {
//              sum+=i;
//              list.add(i);
//            }
//            if(sum==target){
//              result.add(list);
//            }
//            return result;
//        }
        Arrays.sort(nums);
        int left = 0;
        // 固定一个位置即left，然后使用mid 和right查找
        while (nums[left] < target || left < (nums.length - 2)) {
            int mid = left + 1;
            while (left > 0 && nums[mid + 1] == nums[mid]) {
                mid++;
            }
            int right = nums.length - 1;
            // 如果最左两边的数大于target，则不需要再往右边移动了
            if (nums[left] + nums[mid] > target) {
                return result;
            }
            while (mid < right) {
                while (nums[left] + nums[mid] + nums[right] > target && mid < right) {
                    right--;
                    while (nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                while (nums[left] + nums[mid] + nums[right] < target && mid < right) {
                    mid++;
                    while (nums[mid] == nums[mid - 1]) {
                        mid++;
                    }
                }
                if (nums[left] + nums[mid] + nums[right] == target && mid < right) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    result.add(list);
                    mid++;
                }
            }
            while (left < nums.length - 2 && nums[left + 1] == nums[left]) {
                left++;
            }
            left++;
        }
        return result;
    }

    public List<List<Integer>> threeSum_v2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        // 如果第一个数就大于target，则没有继续比较的必要了
        int left = 0;
        while (left < nums.length - 2) {
            if (nums[left] > target) {
                return result;
            }
            int mid = left + 1;
            int right=nums.length-1;
            // 过滤掉左边相同的数
            while (mid<nums.length-2&&nums[mid]==nums[mid+1]){
                mid++;
            }
            while (mid<right){
                if(nums[left]+nums[mid]+nums[right]>target){
                    right--;
                    continue;
                }
                if(nums[left]+nums[mid]+nums[right]<target){
                    mid++;
                    continue;
                }
                if(nums[left]+nums[mid]+nums[right]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    result.add(list);
                    mid++;
                }

            }
            while (left<nums.length-2&&nums[left]==nums[++left]){
//                left++;
            }

        }
        return result;
    }
}
