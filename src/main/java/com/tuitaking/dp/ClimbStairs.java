package com.tuitaking.dp;

/**
 * @author lijing
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *     <p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *     <p>注意：给定 n 是一个正整数。
 *     <p>示例 1：
 *     <p>输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶 示例 2：
 *     <p>输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
 *     <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/climbing-stairs
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {

  /**
   * 用两个数来表示前两步的次数
   * @param n
   * @return
   */
  public int climbStairs(int n) {
      if(n==1){
        return 1;
      }
      if(n==2){
        return 2;
      }
      if(n==0){
        return 0;
      }
      int first=1;
      int second=2;
      int sum=first+second;
      for(int i = 3 ;i<= n;i++){
        sum=first+second;
        first=second;
        second=sum;
      }
      return sum;
  }
  // 第一种方法中的某些条件优化
  public int climbStairs2(int n) {
    if(n<2){
      return n;
    }
    int first=1;
    int second=2;
    for(int i = 3 ;i<= n;i++){
      int tem=first+second;
      first=second;
      second=tem;
    }
    return second;
  }

}
