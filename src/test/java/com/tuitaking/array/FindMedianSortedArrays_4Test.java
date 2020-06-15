package com.tuitaking.array;

import org.junit.Assert;
import org.junit.Test;

public class FindMedianSortedArrays_4Test {

  @Test
  public void test(){
    FindMedianSortedArrays_4 findMedianSortedArrays=new FindMedianSortedArrays_4();
    int[] array1=new int[]{1,3};
    int[] array2=new int[]{2};
    double result=findMedianSortedArrays.findMedianSortedArrays(array1,array2);
   Assert.assertEquals((double) 2.0,(double) result,0.01d);
  }

}
