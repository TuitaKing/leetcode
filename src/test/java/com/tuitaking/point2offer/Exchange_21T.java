package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class Exchange_21T {
    @Test
    public void test(){
        Exchange_21 exchange_21=new Exchange_21();
       int[] arr= exchange_21.exchange(new int[]{1,2,3,4});
        Assert.assertArrayEquals(arr,new int[]{1,3,2,4});
    }
}
