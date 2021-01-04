package com.tuitaking.point2offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinNumber_45 {
    // 想将两个数凑在一起谁大，3 34 ， 30 ，但是觉得可能会溢出，而且解法和String 那个差不错
    public static String minNumber_v4(int[] nums) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int tmp=o1;
                int tmp2=o2;
                while (tmp>10){
                    o2=o2*10;
                    tmp/=10;
                }
                return 0;
            }
        });
        return null;
    }


    public static String minNumber(int[] nums) {
//        PriorityQueue<Integer> priorityQueue=new PriorityQueue(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//              char[] s1= String.valueOf(o1).toCharArray();
//              char[] s2=String.valueOf(o2).toCharArray();
//              int l1=0;
//              int l2=0;
//              while (l1<s1.length || l2<s2.length){
//
//              }
////              for(int i = 0 ;i<Math.max(s1.length,s2.length);i++){
////                  if(s1[i]==s2[i]){
////                      continue;
////                  }
////                  if(s1.length>s2.length){
////                      return s1[s1.length-1]-s2[s2.length-1];
////                  }else {
////
////                  }
////              }
//              return o1-o2;
//            }
//        });
//        for(int i :nums){
//            priorityQueue.add(i);
//        }
//        return "abc";
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    public String minNumber_v1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder s = new StringBuilder();
        for (int d : nums) {
            s.append(d);
        }
        return s.toString();
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r, key = nums[i];
        while (i < j) {
            // 从右开始找第一个小于key的下标,直到i截止，保证大于等于key的都在key的右边
            while (i < j && compare(nums[j], key) >= 0) {
                j --;
            }
            if (i < j) {
                // 如果找到第一个小于key的下标则将该下标对应的值存入左边界（因为左边界的值存入了key或者上一次循环的右边界）
                nums[i ++] = nums[j];
            }
            // 从左开始找第一个大于等于key的下标,直到j截止，注意找到等于key的下标也可以，因为key右边有可能存在比key小的值
            while (i < j && compare(nums[i], key) < 0) {
                i ++;
            }
            if (i < j) {
                // 从左开始找到第一个大于key的下标，找到大于key的下标则将该下标对应的值存入右边界（因为右边界的值存入了左边界）
                nums[j --] = nums[i];
            }
        }
        nums[i] = key;
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    public int compare(int src, int target) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        a.append(src).append(target);
        b.append(target).append(src);
        return a.toString().compareTo(b.toString());
    }

}
