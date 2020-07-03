package com.tuitaking.array;

import java.util.HashMap;

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
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] 为 0 或 1
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

    //v1 尝试优化 忽略了题目的要求，也就是只有0,1
    public int numSubarraysWithSum_V1(int[] A, int S) {
            int sum = 0;
            int result = 0;
            int N = A.length;
            int[] map = new int[N + 1];
            map[0] = 1;
            for (int i = 0; i < N; ++i) {
                sum += A[i];
                if (sum >= S) {
                    result += map[sum - S];
                }
                map[sum]++;
            }
            return result;
        }
    // q前缀和
    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        HashMap<Integer, Integer>
                preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);

        int ans = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            // 如果前面有这个前缀和，则直接更新答案，也就是如果前面已经有了对应的前缀p，
            // 去掉这个前缀和就是preSum[i-1]-preSum[p]，那么从arr[p+1]+...arr[i-1]=k-preSum[p]
            if (preSum.containsKey(sum0_j))
                ans += preSum.get(sum0_j);
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }
}
