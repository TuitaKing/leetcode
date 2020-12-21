package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

public class MinClimbStairs_746T {
    @Test
    public void test(){
        int[] cost=new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost1=new int[]{10, 15, 20};
        MinClimbStairs_746 minClimbStairs_746=new MinClimbStairs_746();
        Assert.assertEquals(minClimbStairs_746.minCostClimbingStairs(cost),6);
        Assert.assertEquals(minClimbStairs_746.minCostClimbingStairs(cost1),15);
    }
}
