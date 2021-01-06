package com.tuitaking.string;


import org.junit.Assert;
import org.junit.Test;

public class LongestPalindrome_5T {
    @Test
    public void test(){
        LongestPalindrome_5 longestPalindrome_5=new LongestPalindrome_5();
        Assert.assertEquals(longestPalindrome_5.longestPalindrome("cbbd"),"bb");
    }


}
