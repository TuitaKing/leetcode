package com.tuitaking.string;

import org.junit.Assert;
import org.junit.Test;

public class CheckValidString_678T {
    @Test
    public void test(){
        CheckValidString_678 checkValidString_678=new CheckValidString_678();
        String str1="(*))(*)";
        String str2="())";
        String str3="(()";
        String str4="(*))*)";
        String str5="(((()*())))((()(((()(()))()**(*)())))())()()*";
        String str6="((*)(*))((*";
        Assert.assertTrue(checkValidString_678.checkValidString(str1));
        Assert.assertTrue(!checkValidString_678.checkValidString(str2));
        Assert.assertTrue(!checkValidString_678.checkValidString(str3));
        Assert.assertTrue(checkValidString_678.checkValidString(str4));
        Assert.assertTrue(checkValidString_678.checkValidString(str5));
        Assert.assertTrue(!checkValidString_678.checkValidString(str6));

    }
}
