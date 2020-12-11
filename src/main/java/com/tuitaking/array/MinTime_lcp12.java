package com.tuitaking.array;

import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
 *
 * 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
 *
 * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
 *
 * 示例 1：
 *
 * 输入：time = [1,2,3,3], m = 2
 *
 * 输出：3
 *
 * 解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。
 *
 * 示例 2：
 *
 * 输入：time = [999,999,999], m = 4
 *
 * 输出：0
 *
 * 解释：在前三天中，小张每天求助小杨一次，这样他可以在三天内完成所有的题目并不花任何时间。
 *
 * 
 *
 * 限制：
 *
 * 1 <= time.length <= 10^5
 * 1 <= time[i] <= 10000
 * 1 <= m <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinTime_lcp12 {

    boolean Check(int limit, int[] cost, int day) {
        // 每组划分 limit 的最大和，贪心划分看有多少组
        int useday, totaltime, maxtime;
        useday = 1; totaltime = maxtime = 0;
        for (int i=0; i<cost.length; ++i) {
            int nexttime = min(maxtime, cost[i]);
            if (nexttime + totaltime <= limit) {
                totaltime += nexttime;
                maxtime = max(maxtime, cost[i]);
            } else {
                ++useday;
                totaltime = 0;
                maxtime = cost[i];
            }
        }
        return (useday <= day);
    }
    // 该提应该是求数组time.length 被分成m份，切每份能减去最大值，然后求和最小的那一份。
    int minTime(int[] time, int m) {
        int left, right, middle;
        left = right = 0;
        for (int i=0; i<time.length; ++i) {
            right += time[i];
        }
        while (left <= right) {
            middle = (left + right) >> 1;
            if (Check(middle, time, m)) right = middle - 1;
            else left = middle + 1;
        }
        return left;
    }


    public int minTime_v1(int[] time, int m) {
        int allTime=0;
        for(int i:time){
            allTime+=i;
        }
        int left=0,right=allTime;
        while (left<right){

        }
        return left;
    }
}
