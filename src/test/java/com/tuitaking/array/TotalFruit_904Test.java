package com.tuitaking.array;

import com.tuitaking.common.MockUtil;
import com.tuitaking.common.Utils;
import org.junit.Assert;
import org.junit.Test;

public class TotalFruit_904Test {
    @Test
    public void test(){
        TotalFruit_904 totalFruit_904=new TotalFruit_904();
        for(int i =0 ; i<100 ; i++){
         int[] test=MockUtil.mockArray(i,10);
            System.out.println(Utils.arratToString(test));
         Assert.assertEquals(totalFruit_904.totalFruit(test),totalFruit_904.totalFruit_v1(test));}
    }
}
