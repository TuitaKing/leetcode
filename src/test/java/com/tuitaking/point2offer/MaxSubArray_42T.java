package com.tuitaking.point2offer;

import com.tuitaking.common.MockUtil;
import com.tuitaking.dp.MaxSubArray_53;
import org.junit.Assert;
import org.junit.Test;

public class MaxSubArray_42T {

    @Test
    public void test(){
        MaxSubArray_42 maxSubArray_42=new MaxSubArray_42();
        MaxSubArray_53 maxSubArray_53=new MaxSubArray_53();
        for(int i = 1 ; i<100;i++){
            int[] arr=MockUtil.mockArray(i);
            Assert.assertEquals(maxSubArray_42.maxSubArray(arr),maxSubArray_53.maxSubArray_v2(arr));
        }

    }
}
