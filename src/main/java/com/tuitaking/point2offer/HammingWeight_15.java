package com.tuitaking.point2offer;

/**
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HammingWeight_15 {
    public int hammingWeight(long n) {
        int res=0;
        System.out.println( Long.toBinaryString(n));
        // 使用这种方式，如果是32的好像会出问题
        for (int i = 0; i < 32; i++) {
            if(n%2==1){
                res++;
            }
            n=n>>1;
        }
        return res;
    }
    public int hammingWeight_leetcode(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

}
