package com.tuitaking.tanxin;

import org.junit.Assert;
import org.junit.Test;

public class WiggleMaxLength_376T {
    @Test
    public void test(){
        WiggleMaxLength_376 maxLength_376=new WiggleMaxLength_376();
        Assert.assertEquals(maxLength_376.wiggleMaxLength(new int[]{3,3,3,2,5}),3);
    }
}
