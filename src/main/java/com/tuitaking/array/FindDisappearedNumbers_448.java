package com.tuitaking.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在 1 ≤ a[i] ≤ n (n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * [4,3,2,7,8,2,3,1]
 */
public class FindDisappearedNumbers_448 {
    public List<Integer> findDisappearedNumbers_v1(int[] nums) {
        List<Integer> integers=new ArrayList<>();
        for(int i=0;i<nums.length;++i) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0) {
                nums[index] *= -1;
            }
        }
        for(int i = 0 ; i < nums.length;i++){
            if(nums[i]>0){
                integers.add(i+1);
            }
        }
        return integers;
    }

    /**
     * 并不是1--n的数放在n-1的数组里，所以此种解法是有问题的
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums){
        ArrayList<Integer> integers=new ArrayList<>(nums.length);
        for(int i=0;i<nums.length;++i) {
          while (nums[nums[i]-1]!=(i+1)){
              if(nums[nums[i]-1]==nums[i]){
                  break;
              }
              int tmp=nums[i];
              nums[i]=nums[tmp-1];
              nums[tmp-1]=tmp;
          }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1!=i){
                integers.add(i+1);
            }
        }
        return integers;
    }




}
