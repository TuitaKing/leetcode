package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class HammingWeight_15T {
    @Test
    public void test(){
        HammingWeight_15 hammingWeight_15=new HammingWeight_15();
        Assert.assertEquals(hammingWeight_15.hammingWeight(Integer.MIN_VALUE-4),31);
    }
}
