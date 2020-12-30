package com.tuitaking.stack;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleArea_84T {
    @Test
    public void  test(){
        LargestRectangleArea_84 largestRectangleArea_84=new LargestRectangleArea_84();
        Assert.assertEquals(largestRectangleArea_84.largestRectangleArea_v1(new int[]{1,2,3,4,5}),9);
    }
}
