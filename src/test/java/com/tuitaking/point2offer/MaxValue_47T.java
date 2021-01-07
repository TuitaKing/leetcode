package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class MaxValue_47T {
    @Test
    public void test(){
        MaxValue_47 maxValue_47=new MaxValue_47();
        Assert.assertEquals(maxValue_47.maxValue(new int[][]{
                {1,3,1},
                {2,5,1},
                {10,2,1}
        }),16);;
        Assert.assertEquals(maxValue_47.maxValue(new int[][]{
                {1,3,1},
        }),5);;
    }
}
