package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLongestSubstring_48T {
    @Test
    public void test(){
        LengthOfLongestSubstring_48 lengthOfLongestSubstring_48=new LengthOfLongestSubstring_48();
        Assert.assertEquals(lengthOfLongestSubstring_48.lengthOfLongestSubstring("pwwkew"),3);
        Assert.assertEquals(lengthOfLongestSubstring_48.lengthOfLongestSubstring("bbbbb"),1);
        Assert.assertEquals(lengthOfLongestSubstring_48.lengthOfLongestSubstring("av"),2);
    }
}
