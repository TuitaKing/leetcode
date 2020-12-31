package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

public class EraseOverlapIntervalsT {
    @Test
    public void test(){
      int[][] arrays=  new int[][]{ {1,2}, {2,3}, {3,4}, {1,3} };
      int[][] arrays1=  new int[][]{{1,100},{11,22},{1,11},{2,12}};
        EraseOverlapIntervals eraseOverlapIntervals=new EraseOverlapIntervals();
        Assert.assertEquals(eraseOverlapIntervals.eraseOverlapIntervals(arrays),1);
        Assert.assertEquals(eraseOverlapIntervals.eraseOverlapIntervals(arrays1),2);
    }
}
