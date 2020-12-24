package com.tuitaking.tanxin;

import org.junit.Assert;
import org.junit.Test;

public class AssignCookies_455T {
    @Test
    public void test(){
        AssignCookies_455 assignCookies_455=new AssignCookies_455();
        Assert.assertEquals(assignCookies_455.findContentChildren(new int[]{5,10,2,9,15,9},new int[]{6,1,20,3,5}),3);
    }

}
