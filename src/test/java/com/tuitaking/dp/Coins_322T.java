package com.tuitaking.dp;

import org.junit.Assert;
import org.junit.Test;

public class Coins_322T {
    @Test
    public void test(){
       Coins_322 coins_322=new Coins_322();
        int[] coins = {1, 2, 5};
        int amount = 11;
        Assert.assertEquals(coins_322.coinChange(coins,amount),3);
    }
}
