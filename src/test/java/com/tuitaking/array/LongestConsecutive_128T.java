package com.tuitaking.array;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutive_128T {
    @Test
    public void test(){
        LongestConsecutive_128  longestConsecutive_128=new LongestConsecutive_128();
//        Assert.assertEquals(longestConsecutive_128.longestConsecutive_v1(new int[]{100,4,200,1,3,2}),4);
//        Assert.assertEquals(longestConsecutive_128.longestConsecutive_v1(new int[]{0,3,7,2,5,8,4,6,0,1}),9);
//        Assert.assertEquals(longestConsecutive_128.longestConsecutive_v1(new int[]{1,2,0,1}),3);
        Assert.assertEquals(longestConsecutive_128.longestConsecutive_v1(new int[]{1,0,-1}),3);
    }
}
