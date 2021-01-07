package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqChar_50T {
    @Test
    public void test(){
        FirstUniqChar_50 firstUniqChar_50=new FirstUniqChar_50();
        Assert.assertEquals(firstUniqChar_50.firstUniqChar("leetcode"),firstUniqChar_50.firstUniqChar_v1("leetcode"));
        Assert.assertEquals(firstUniqChar_50.firstUniqChar("loveleetcode"),firstUniqChar_50.firstUniqChar_v2("loveleetcode"));
        Assert.assertEquals(firstUniqChar_50.firstUniqChar("cc"),firstUniqChar_50.firstUniqChar_v2("cc"));
    }
}
