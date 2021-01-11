package com.tuitaking.point2offer;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * 1是丑数。
 * n不超过1690。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber_49 {

    public int nthUglyNumber(int n) {
        int three=0,two=0,five=0;
        int[] dp=new int[n];
        dp[0]=1;
        for (int i = 1; i < n; ++i) {
            int t1 = dp[two] * 2, t2 = dp[three] * 3, t3 = dp[five] * 5;
            dp[i] = Math.min(Math.min(t1, t2), t3);

            if (dp[i] == t1) {++ two;}
            if (dp[i] == t2) {++ three;}
            if (dp[i] == t3) {++ five;}
        }
        return dp[n-1];
    }
}
