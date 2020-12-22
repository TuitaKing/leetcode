package com.tuitaking.dp;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 * 示例1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Coins_322 {
    public int coinChange(int[] coins, int amount) {
      int[] dp=new int[amount+1];
      for(int i = 0 ;i<amount+1;i++){
          dp[i]=amount+1;
      }
      dp[0]=0;
      for(int i = 0 ; i< amount+1;i++){
          for(int coin:coins){
             if(i-coin<0){
                 break;
             }
              dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
          }
      }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
    // 回溯
    public int coinChange_v1(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }

    int res = Integer.MAX_VALUE;
    public int coinChange_v2(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        Arrays.sort(coins);
        mincoin(coins,amount,coins.length-1,0);
        return res==Integer.MAX_VALUE? -1:res;
    }
    private void mincoin(int[] coins,int amount, int index, int count){
        if(amount==0){
            res = Math.min(res,count);
            return;
        }
        if(index<0){
            return;
        }
        for(int i = amount/coins[index];i>=0 && i+count<res; i--){
            mincoin(coins,amount - (i*coins[index]), index-1, count+i);
        }
    }

}
