package com.tuitaking.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 
 *
 * 进阶：你可以设计并实现时间复杂度为O(n) 的解决方案吗？
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive_128 {
    // 用最小堆存放数据，然后每次从堆顶拿数据
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i :nums){
            queue.offer(i);
        }
        int res=0;
        int temp=queue.poll();
        int next=1;
        while (!queue.isEmpty()){
            if(temp==queue.peek()){
                queue.poll();
                continue;
            }
            if(temp-queue.peek()==-1){
                next++;
            }else{
                res=Math.max(next,res);
                next=1;
            }
            temp=queue.poll();
        }
        res=Math.max(next,res);
        return res;
    }
    // 使用Map
    public int longestConsecutive_v1(int[] nums) {
        Map<Integer,Integer> maps=new HashMap<>();
        for(int i :nums){
            maps.put(i, maps.getOrDefault(i,1));
        }
        int res=0;
        int count=0;
        for(Integer i: maps.keySet()){
            int j=i;
            while (maps.get(j)!=null){
                j++;
                count++;
            }
            res=Math.max(count,res);
            count=0;
        }
        return res;
    }


}
