package com.tuitaking.array;

import java.util.Arrays;

/**
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有n个空的篮子，第i个篮子的位置在position[i]，Morty想把m个球放到这些篮子里，使得任意两球间最小磁力最大。
 *
 * 已知两个球如果分别位于x和y，那么它们之间的磁力为|x - y|。
 *
 * 给你一个整数数组position和一个整数m，请你返回最大化的最小磁力。
 * 示例 1：
 * 输入：position = [1,2,3,4,7], m = 3
 * 输出：3
 * 解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 * 示例 2：
 * 输入：position = [5,4,3,2,1,1000000000], m = 2
 * 输出：999999999
 * 解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 * 提示：
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有position中的整数 互不相同。
 * 2 <= m <= position.length
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magnetic-force-between-two-balls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDistance_1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }



   // 最小的磁力为相邻小球，判断的应该是相邻之间的磁力是否都大于当前居中的磁力，而且能够放下所有的小球，如果是，则说明当前的磁力过小

    public boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }


    public static int findMaxDis(int[] nums,int m){
        Arrays.sort(nums);
        int left=1,right=nums[nums.length-1]-nums[0];
        int res=0;
        //left 为最小的值，right为最大的值
        while (left<=right){
            int mid=(left+right)/2;
            if(check_v1(mid,nums,m)){
                res=mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return res;
    }
    private static boolean check_v1(int mid,int[] nums,int m){
        int res=0;
        int pre=nums[0];
        for(int i = 1;i<nums.length;i++){
            if(Math.abs(nums[i]-pre)>=mid){
               res++;
               pre=nums[i];
            }
        }
        return res>=m;
    }

    public static void main(String[] args) {
        MaxDistance_1552 maxDistance_1552=new MaxDistance_1552();
        maxDistance_1552.maxDistance(new int[]{1,2,3,4,5,10000},2);
    }
}
