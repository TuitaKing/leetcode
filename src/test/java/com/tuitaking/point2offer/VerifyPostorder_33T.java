package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class VerifyPostorder_33T {
    @Test
    public void test(){
        VerifyPostorder_33 verifyPostorder_33=new VerifyPostorder_33();
        Assert.assertTrue(!verifyPostorder_33.verifyPostorder(new int[]{1,6,3,2,5}));
        Assert.assertTrue(verifyPostorder_33.verifyPostorder(new int[]{1,3,2,6,5}));
        Assert.assertTrue(verifyPostorder_33.verifyPostorder(new int[]{1}));
        Assert.assertTrue(verifyPostorder_33.verifyPostorder(new int[]{1,2}));
        Assert.assertTrue(!verifyPostorder_33.verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
        Assert.assertTrue(!verifyPostorder_33.verifyPostorder(new int[]{3,10,6,9,2}));
    }
}
