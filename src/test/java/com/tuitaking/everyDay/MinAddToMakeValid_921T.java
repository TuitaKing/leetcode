package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

public class MinAddToMakeValid_921T {
    @Test
    public void test(){
        MinAddToMakeValid_921 minAddToMakeValid_921=new MinAddToMakeValid_921();
        Assert.assertEquals(minAddToMakeValid_921.minAddToMakeValid_v1("()))(("),4);
        Assert.assertEquals(minAddToMakeValid_921.minAddToMakeValid("())"),1);
        Assert.assertEquals(minAddToMakeValid_921.minAddToMakeValid("()"),0);
        Assert.assertEquals(minAddToMakeValid_921.minAddToMakeValid("((("),3);
        Assert.assertEquals(minAddToMakeValid_921.minAddToMakeValid(""),0);
    }
}
