package com.tuitaking.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lijing
 */
public class ThreeSum_v15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result=new ArrayList<>();
    if(nums.length<3){
      return result;
    }
    if(nums.length==3){
      List<Integer> list=new ArrayList<>();
      for(Integer i:nums){
        list.add(i);
      }
      result.add(list);
      return result;
    }
    Arrays.sort(nums);
    int left=0;
    int right=nums.length-1;
    int mid=0;
    while (left<right){
     // int twoSum=nums[left]+nums[right];
      if(nums[left]+nums[right]>0){
        int twoSum=nums[left]+nums[right];
        mid=left+1;
        while (twoSum+nums[mid]<0){
            mid++;
        }
        if(twoSum+nums[mid]==0){
          List<Integer> list=new ArrayList<>();
          list.add(nums[left]);
          list.add(nums[mid]);
          list.add(nums[right]);
        }

      }
    }
    return result;
  }
  
}
