package com.tuitaking.tanxin;

import java.util.Arrays;

public class Coins {

    // 与Coins_322 有区别的地方时，这种解法父选项一定是自选项的倍数
    public int coinChange(int[] coins, int amount) {
        int res=0;
        Arrays.sort(coins);
        int use=0;
        for(int i = coins.length-1;i>=0;i--){
            if(amount<=0){
                break;
            }
            use=amount/coins[i];
            res+=use;
            amount=amount-coins[i]*use;
        }
        return res;
    }
}
