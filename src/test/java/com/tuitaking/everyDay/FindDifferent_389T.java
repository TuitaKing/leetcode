package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

public class FindDifferent_389T {
    @Test
    public void test(){
        String a="abcd";
        String b="adabc";
        FindDifferent_389 findDifferent_389=new FindDifferent_389();
        Assert.assertEquals(findDifferent_389.findTheDifference(a,b),'a');
    }
}
