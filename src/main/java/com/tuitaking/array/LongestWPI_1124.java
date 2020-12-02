package com.tuitaking.array;

/**
 * 给你一份工作时间表hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *
 * 请你返回「表现良好时间段」的最大长度。
 *
 *
 * 示例 1：
 *
 * 输入：hours = [9,9,6,0,9,9,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *
 * 提示：
 *
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWPI_1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        for(int i = 0; i < n; i++){
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = i; j < n; j++){
                count += hours[j];
                if(count > 0)
                    res = Math.max(res, j - i + 1);
            }
            if(n - i <= res)
                return res;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] hours=new int[]{9,6,9,0,6,9,9,9};
        System.out.println(new LongestWPI_1124().longestWPI(hours));
    }
}
