package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicateLetters_316T {
    @Test
    public void test(){
        String s = "bcabc";
        String s1 = "cbacdcbc";
        RemoveDuplicateLetters_316 removeDuplicateLetters_316=new RemoveDuplicateLetters_316();
        Assert.assertEquals(removeDuplicateLetters_316.removeDuplicateLetters(s),"abc");
        Assert.assertEquals(removeDuplicateLetters_316.removeDuplicateLetters(s1),"acdb");
    }
}
