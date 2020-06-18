package com.tuitaking.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_v1 {
    public static void main(String[] args) {
        int[] nums=new int[]{3,2,4};
        TwoSum_v1 twoSum_v1=new TwoSum_v1();
        int[] a=twoSum_v1.twoSum_v1(nums,6);
        System.out.println("asd");
    }
    // 前面是数值，后面是数值的index
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i = 0 ; i < nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0 ; i<nums.length;i++){
            int tmp=target-nums[i];
            if(map.get(tmp)!=null && map.get(tmp)!=i){
                return new int[]{i,map.get(tmp)};
            }
        }
        return null;
    }

    // 仅一次遍历
    public int[] twoSum_v1(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int left=target-nums[i];
            if(map.containsKey(left)){
                return new int[]{map.get(left),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}

/**
 * 如果已经排好序则好做一点，和三个数只和差不多，使用map来记录数据
 * */