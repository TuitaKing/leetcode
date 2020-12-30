package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

public class LastStoneWeight_1046T {
    @Test
    public void test(){
        LastStoneWeight_1046 lastStoneWeight_1046=new LastStoneWeight_1046();
        Assert.assertEquals(lastStoneWeight_1046.lastStoneWeight(new int[]{2,7,4,1,8,1}),1);
        Assert.assertEquals(lastStoneWeight_1046.lastStoneWeight(new int[]{1,1,1,1,1,1}),0);
        Assert.assertEquals(lastStoneWeight_1046.lastStoneWeight(new int[]{1,1,1}),1);
        Assert.assertEquals(lastStoneWeight_1046.lastStoneWeight(new int[]{1}),1);
    }
}
