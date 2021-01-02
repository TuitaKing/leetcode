package com.tuitaking.point2offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetLeastNumbers_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0||k==0){
            return new int[0];
        }
        PriorityQueue<Integer> integers=new PriorityQueue<>(k);
        for(int i : arr){
            integers.offer(i);
        }
        int[] res=new int[k];
        for(int i = 0 ;i <k;i++){
            res[i]=integers.poll();
        }
        return res;
    }

    public int[] getLeastNumbers_v1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res=new int[k];
        System.arraycopy(arr,0,res,0,k);
        return res;
    }
}
