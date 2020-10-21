package com.tuitaking.binary_search_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class Intersect_350 {
    /**
     * 该方法没有用到题目中提到顺序无关的，可以现排序然后在对比
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if(len1<len2){
            // 保证nums1的长度是长的那个
            return intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> count=new HashMap<>();
        for(int i:nums2){
            Integer num=count.get(i);
            if(num==null){
                num=1;
            }else {
                num++;
            }
            count.put(i,num);
        }
        List<Integer> res=new ArrayList<Integer>();
        for(Integer i:nums1){
            if(count.get(i)!=null&& count.get(i)>0){
                res.add(i);
                count.put(i,count.get(i)-1);
            }
        }

        int[] result=new int[res.size()];
        int j=0;
        for(int i:res){
            result[j]=i;
            j++;
        }
        return  result;
    }

    public int[] intersect_v1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        for( int i =0,j =0;i<nums1.length &&j<nums2.length;){
            if(nums1[i] == nums2[j]){
                nums1[count++] =nums1[i++];
                j++;
            }else if(nums1[i]<nums2[j]){ i++;}
            else{ j++;}
        }
        return Arrays.copyOfRange(nums1,0,count);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        Intersect_350 intersect_350=new Intersect_350();
        int[] res=intersect_350.intersect(nums1,nums2);
        for(int i :res){
            System.out.println(i);
        }

    }
}
