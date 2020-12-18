package com.tuitaking.everyDay;

/**
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit_714 {
    public int maxProfit(int[] prices, int fee) {
        int leftMin = Integer.MAX_VALUE;
        int leftMax = Integer.MIN_VALUE;
        int res = 0;
        int preMin = 0;
        int preRes = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == Math.min(leftMin, prices[i])) {
                leftMin = prices[i];
                continue;
            } else if (prices[i] == Math.max(leftMax, prices[i])) {
                leftMax = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] > leftMax) {
                        leftMax = prices[j];
                        i = j;
                        continue;
                    } else {
                        break;
                    }
                }
            }
            //1, 5, 2, 8, 4, 9
            if (leftMax - leftMin - fee > 0) {

//                if(preMin!=0&&((leftMax - leftMin - fee)+preRes)<(leftMax-preMin-fee)){
//                    res+=leftMax-preMin-fee-preRes;
//                }else{
//                    res += leftMax - leftMin - fee;
//                }
                res += leftMax - leftMin - fee;
                // System.out.println("leftMax: "+leftMax+ " leftMin: "+leftMin+" preMin: "+preMin+" preRes: "+preRes+ " res :"+res);
            }
            preRes = leftMax - leftMin - fee;
            preMin = leftMin;
            leftMin = Integer.MAX_VALUE;
            leftMax = Integer.MIN_VALUE;

        }
        return res;
    }

    public int maxProfit_my_v1(int[] prices, int fee) {
        int min = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min - fee > 0) {
                res += prices[i] - min - fee;
                min = prices[i] - fee; //如果没有卖出的话，下次在卖的价格应该是当前的价格减去手续费
            }
        }
        return res;
    }


    public int maxProfit_v1(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    //1, 5, 6, 8, 4, 9
    public int maxProfit_fast(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {  // 如果当前买的价格小于原来的价格，就在当前买入，
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {  // 有获利的时候就卖出
                profit += prices[i] - buy;
                buy = prices[i];           //当前 卖出后，假定没有卖出，所以他的buy价格只是当前的值。下次获利更高的话，就可以按照第一次买入的价格卖出。
            }
        }
        return profit;
    }

    public int maxProfit_fast_v1(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

}
