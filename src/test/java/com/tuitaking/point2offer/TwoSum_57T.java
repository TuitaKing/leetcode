package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class TwoSum_57T {
    @Test
    public void test(){
        TwoSum_57 twoSum_57=new TwoSum_57();
        Assert.assertArrayEquals(twoSum_57.twoSum(new int[]{2,7,11,15},9),new int[]{2,7});
    }
}
