package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

public class CanPlaceFlowers_605T {
    @Test
    public void test(){
        CanPlaceFlowers_605 canPlaceFlowers_605=new CanPlaceFlowers_605();
        Assert.assertTrue(canPlaceFlowers_605.canPlaceFlowers_v1(new int[]{1,0,0,0,1},1));
        Assert.assertTrue(!canPlaceFlowers_605.canPlaceFlowers_v1(new int[]{1,0,0,0,1},2));
        Assert.assertTrue(canPlaceFlowers_605.canPlaceFlowers_v1(new int[]{0,0,0,0},2));
        Assert.assertTrue(canPlaceFlowers_605.canPlaceFlowers_v1(new int[]{0,0,1,0,0},2));
        Assert.assertTrue(canPlaceFlowers_605.canPlaceFlowers_v1(new int[]{0},1));
        Assert.assertTrue(canPlaceFlowers_605.canPlaceFlowers_v1(new int[]{1,0,0},1));
        Assert.assertTrue(canPlaceFlowers_605.canPlaceFlowers_v1(new int[]{1,0,0,0,1,0,0},1));
    }
}
