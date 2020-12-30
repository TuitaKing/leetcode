package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class Min_11T {
    @Test
  public void test(){
      Min_11 min_11=new Min_11();
//      Assert.assertEquals(min_11.minArray(new int[]{3,4,5,1,2}),1);
//      Assert.assertEquals(min_11.minArray(new int[]{2,2,2,0,1}),0);
//      Assert.assertEquals(min_11.minArray(new int[]{1,2,3}),1);
      Assert.assertEquals(min_11.minArray(new int[]{3,2,1}),1);
    }
}
