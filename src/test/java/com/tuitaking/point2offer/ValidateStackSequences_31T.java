package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class ValidateStackSequences_31T {
    @Test
    public void test(){
        ValidateStackSequences_31 validateStackSequences_31=new ValidateStackSequences_31();
        Assert.assertTrue(!validateStackSequences_31.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
       Assert.assertTrue(validateStackSequences_31.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }

}
