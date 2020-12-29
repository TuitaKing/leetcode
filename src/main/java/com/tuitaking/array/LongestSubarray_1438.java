package com.tuitaking.array;


import java.util.LinkedList;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubarray_1438 {
    // 此方法不是适合与[1,2,3,4,5,2,3,4] 3 的情况，因为都是从前往后，但是没有记录数据，还是要走滑动窗口
    public static int longestSubarray(int[] nums, int limit) {
        if(nums.length==0){
            return 0;
        }
        int start = 0 ;
        int end=0;
        int min=nums[0];
        int max=nums[0];
        int res=0;
        while (start<nums.length){
            if((max-min)<=limit){
                max=Math.max(max,nums[start]);
                min=Math.min(min,nums[start]);
                res=Math.max(res,start-end+1);
            }else {
                min=nums[start];
                max=nums[start];
                end=start;
            }
            start++;
        }
        return res;
    }
   //1,5,6,7,8,10,6,5,6 4
    public static int longestSubarray_v2(int[] nums, int limit) {
        int left=0,right=0;
        //start end 是滑动窗口的两边，
        int min=nums[0],max=nums[0];//窗口里的最大值和最小值
        int res=0,minIndex=0;
        while (right<nums.length){  // 右边跑到了数组边界
            if(Math.abs(nums[right]-nums[minIndex])<=limit){ //如果当前的数值和窗口中最小的数之差小于limit，则将当前数字放入窗口
               res=Math.max(res,right-left+1);
               //如果当前的值小于记录的最小值，则记录最小值
                if(nums[right]<=nums[minIndex]){
                    minIndex=right;
                }
            }else { //当前的数和最小的之差大于limit,说明现在的值比窗口中最大的数还要大，从minIndex后面查找适合的窗口大小
                int minLeft=minIndex;
                while (minLeft<=right){ //当前窗口的值
                    if(Math.abs((nums[right]-nums[minLeft]))<=limit){
                        left=minLeft; // 窗口左边
                        minIndex=left;
                        while (minLeft<=right){ //新窗口中最小的数
                            if(nums[minLeft]<=nums[minIndex]){
                                minIndex=minLeft;
                            }
                            minLeft++;
                        }
                        break;
                    }
                    minLeft++;
                }
            }
            right++;
        }
         return res;
    }

    //满足条件的情况应该是窗口中最大的数和最小的数之差小于limit
    public  static int longestSubarray_v3(int[] nums,int limit){
        int left=0,right=0,res=0;
        int minIndex=0,maxIndex=0;
        int min=nums[minIndex],max=nums[maxIndex];
        while (right<nums.length){
              if(Math.abs(nums[right]-min)<=limit && Math.abs(nums[right]-max)<=limit){ // 如果当前的值符合条件，则放入窗口中
                  res=Math.max(right-left+1,res);
                  System.out.println("left:"+left+" : "+nums[left]+" right : "+ right +" : "+nums[right]+"res:"+res);
                  if(nums[right]<=min){
                      minIndex=right;
                      min=nums[right];
                  }
                  if(nums[right]>=max){
                      maxIndex=right;
                      max=nums[right];
                  }
              }
              if(Math.abs(nums[right]-min)>limit){
                  // 如果当前的值与最大值之间的查都大于limit,则重新开始
                  if(Math.abs(nums[right]-max)>limit){
                      left=right;
                      maxIndex=right;
                      minIndex=right;
                      max=nums[right];
                      min=nums[right];
                  }else {
                      max=nums[right];//此时最大的值是nums[right]
                      int windLeft=minIndex;
                      while (windLeft<=right){
                          if(Math.abs(max-nums[windLeft])<=limit){ // 因为当前是最小的值太小，所以从最小的值右边找到合适的区间
                              left=windLeft;
                              break;
                          }
                          windLeft++;
                      }
                      if(windLeft==right){
                          left=right;
                          maxIndex=right;
                          minIndex=right;
                          max=nums[right];
                          min=nums[right];
                      }else {
                          min = nums[windLeft]; //
                          while (windLeft <= right) {
                              if (nums[windLeft] <= min) {
                                  min = nums[windLeft];
                                  minIndex = windLeft;
                              }
                              windLeft++;
                          }
                      }
                  }
              }else
              if(Math.abs(max-nums[right])>limit){ //如果是当前的数减去现有的窗口中最大的值大于limit，则
                    if(nums[right]<min){
                        maxIndex=right;
                        min=nums[right];
                        left=right;
                        minIndex=right;
                    }else {
                        min=nums[right];
                        int windLeft=maxIndex;
                        while (windLeft<=right){
                            if(Math.abs(min-nums[windLeft])<=limit){
                                left=windLeft;
                                break;
                            }
                            windLeft++;
                        }
                        if(windLeft==right){
                            left=right;
                            maxIndex=right;
                            minIndex=right;
                            min=nums[right];
                        }else {
                            max=nums[windLeft];
                            while (windLeft<right){
                                if(Math.max(nums[windLeft],max)!=max){
                                    max=nums[windLeft];
                                    maxIndex=windLeft;
                                }
                                windLeft++;
                            }
                        }

                    }
              }
              right++;
        }
        return res;
    }


    public  static int longestSubarray_v4(int[] nums,int limit){
        if(nums.length==0) return 0;
        int left=0,right=0;
        int minIndex=0,maxIndex=0;
        int res=0;
        while (right< nums.length){
            if(Math.abs(nums[right]-nums[maxIndex])<=limit && Math.abs(nums[right]-nums[minIndex])<=limit){
                //System.out.println("left "+left+" : "+nums[left]+" right "+right+" : "+ nums[right]+" res :" +res);
                res=Math.max(right-left+1,res);
                if(nums[right]>=nums[maxIndex]){
                    maxIndex=right;
                }else if(nums[right]<=nums[minIndex]){
                    minIndex=right;
                }
            }else if(nums[right]>nums[maxIndex]){ //不符合条件有两种情况，第一种，现在的值比里面最大的大，包含的情况就是当前的值减去最小的值大于limit
                maxIndex=right; //当前的值为最大的数字
                int windLeft=minIndex;
                while (windLeft<=right){ // 找到剩下的最小的数
                  if(Math.abs(nums[right]-nums[windLeft])<=limit){
                      left=windLeft;
                      minIndex=getWindsMinIndex(nums,windLeft,right);
                      if(Math.abs(nums[right]-nums[minIndex])<=limit){
                          break;
                      }
                  }
                  windLeft++;
                }
            }if(nums[right]<nums[minIndex]){ // 第二种情况，当前的值比窗口中最小的数还小
                minIndex=right;
                int windLeft=maxIndex;
                while (windLeft<=right){
                    if(Math.abs(nums[right]-nums[windLeft])<=limit){
                        left=windLeft;
                        maxIndex=getWindsMaxIndex(nums,windLeft,right);
                        if(Math.abs(nums[right]-nums[maxIndex])<=limit){
                          break;
                        }

                    }
                    windLeft++;
                }
            }
            right++;
        }
        return res;
    }

    private static int getWindsMinIndex(int[] nums,int start,int right){
        int tempIndex=start;
        while (start<=right){
            if (nums[tempIndex]>=nums[start]){
                tempIndex=start;
            }
            start++;
        }
        return tempIndex;
    }

    private static int getWindsMaxIndex(int[] nums,int start,int right){
        int tempIndex=start;
        while (start<=right){
            if (nums[tempIndex]<=nums[start]){
                tempIndex=start;
            }
            start++;
        }
        return tempIndex;
    }


    public static class MaxQueue {
        private LinkedList<Integer> queue = new LinkedList<>();

        public void push(int val) {
            while (!queue.isEmpty() && queue.getLast() < val) {
                queue.removeLast();
            }
            queue.addLast(val);
        }

        public void pop(int n) {
            if (n == queue.getFirst()) {
                queue.removeFirst();
            }
        }

        public int getMax() {
            return queue.getFirst();
        }
    }

    public static class MinQueue {
        private LinkedList<Integer> queue = new LinkedList<>();

        public void push(int val) {
            while (!queue.isEmpty() && queue.getLast() > val) {
                queue.removeLast();
            }
            queue.addLast(val);
        }

        public void pop(int n) {
            if (n == queue.getFirst()) {
                queue.removeFirst();
            }
        }

        public int getMin() {
            return queue.getFirst();
        }
    }


    public int longestSubarray_leetcode(int[] nums, int limit) {
        int left = 0, right = 0;
        int res = 0;
        MaxQueue maxQueue = new MaxQueue();
        MinQueue minQueue = new MinQueue();
        while (right < nums.length) {
            maxQueue.push(nums[right]);
            minQueue.push(nums[right]);
            ++right;
            while (maxQueue.getMax() - minQueue.getMin() > limit) {
                maxQueue.pop(nums[left]);
                minQueue.pop(nums[left]);
                ++left;
            }
            if (right - left > res) {
                res = right - left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println( LongestSubarray_1438.longestSubarray_v4(new int[]{24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33
//                                                         ,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,
//                                                          27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39},87));
//        System.out.println(LongestSubarray_1438.longestSubarray_v4(new int[]{8,2,4,7},4));
//        System.out.println(LongestSubarray_1438.longestSubarray_v4(new int[]{10,1,2,4,7,2},5));
    //    System.out.println(LongestSubarray_1438.longestSubarray_v4(new int[]{4,2,2,2,4,4,2,2},20));
        System.out.println(LongestSubarray_1438.longestSubarray_v4(new int[]{2,2,2,4,4,2,5,5,5,5,5,2},2));//6
//        System.out.println(LongestSubarray_1438.longestSubarray_v4(new int[]{1,2,3,4,5,2,3,4},3));
//        System.out.println(LongestSubarray_1438.longestSubarray_v4(new int[]{1,5,6,7,8,10,6,5,6},4));
//        System.out.println(LongestSubarray_1438.longestSubarray_v4(new int[]{7,40,10,10,40,39,96,21,54,73,
//                                                                             33,17,2,72,5,76,28,73,59,22,
//                                                                             100,91,80,66,5,49,26,45,13,27,74,87,56,76,25,64,14,86,50,38,65,64,3,42,79,52,37,3,21,26,42,73,18,44,55,28,35,87},63));

    }
}
