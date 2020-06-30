package com.tuitaking.array;

/**
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：A = [1,0,1,0,1], S = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSubArrayWithSum_930 {
    /**
     * 这种方法使用暴力计算的方式，缺少了记录已经计算过的数据，造成重复计算，应该想办法记录
     * @param array
     * @param target
     * @return
     */
    public int numSubarraysWithSum(int[] array, int target) {
        if(array.length<1){
            return 0;
        }
        int len=0;
        int sum=0;
        for(int i = 0 ; i< array.length;i++){
            sum=array[i];
            if(sum==target){
                len++;
            }
            for(int second=i+1;second<array.length;second++){
                sum+=array[second];
                 if(sum==target){
                     len++;
                 }
                 if(sum>target){
                     break;
                 }
            }
        }
        return len;
    }
}
