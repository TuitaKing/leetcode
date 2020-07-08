package com.tuitaking.array;

import com.tuitaking.dp.MaxSubArray_53;
import org.junit.Test;

public class MaxSubArray_53Test {
    @Test
    public void test(){
        MaxSubArray_53 maxSubArray_53=new MaxSubArray_53();
        int[] arr=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray_53.maxSubArray_v1(arr));
    }
}
