package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqChar_387T {
    @Test
    public void test(){
        FirstUniqChar_387 firstUniqChar_387=new FirstUniqChar_387();
        Assert.assertEquals(firstUniqChar_387.firstUniqChar("leetcode"),0);
        Assert.assertEquals(firstUniqChar_387.firstUniqChar("loveleetcode"),2);
        Assert.assertEquals(firstUniqChar_387.firstUniqChar(""),-1);
        Assert.assertEquals(firstUniqChar_387.firstUniqChar("aabbcc"),-1);
    }
}
