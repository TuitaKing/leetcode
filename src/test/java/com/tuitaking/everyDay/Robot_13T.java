package com.tuitaking.everyDay;

import com.tuitaking.common.MockUtil;
import com.tuitaking.point2offer.Robot_13;
import org.junit.Assert;
import org.junit.Test;

public class Robot_13T {
    @Test
    public void test(){
        Robot_13 robot_13=new Robot_13();
//        for(int i = 0 ;i<100;i++){
//            int m=MockUtil.mockArray(1)[0];
//            int n=MockUtil.mockArray(1)[0];
//            int k=MockUtil.mockArray(1)[0];
//            System.out.println("m:"+m+" n:"+n+" k:"+k);
//            Assert.assertEquals(robot_13.movingCount(m+1,n+1,k),robot_13.movingCount_v1(m+1,n+1,k));
//        }
      robot_13.movingCount_v1(99,70,27);
    }
}
