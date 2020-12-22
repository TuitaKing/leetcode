package com.tuitaking.dp;

import com.tuitaking.common.MockUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxSubArray_53T {
    @Test
    public void test(){
        MaxSubArray_53 maxSubArray_53=new MaxSubArray_53();
//        for (int i = 0; i < 10; i++) {
            //int[] arr= MockUtil.mockArray(10);
            int[] arr= new int[]{1,2};
            System.out.println(Arrays.toString(arr));
            Assert.assertEquals(maxSubArray_53.myPre(arr),maxSubArray_53.maxSubArray_v2(arr));

//        }

    }
}
