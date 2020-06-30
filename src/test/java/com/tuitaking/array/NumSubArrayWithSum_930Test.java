package com.tuitaking.array;

import com.tuitaking.common.MockUtil;
import com.tuitaking.common.Utils;
import org.junit.Test;

public class NumSubArrayWithSum_930Test {
    @Test
    public void test(){
        NumSubArrayWithSum_930 numSubArrayWithSum_930=new NumSubArrayWithSum_930();
        int[] array=new int[]{10,1,1,1,0,0,1};// MockUtil.mockArray(10,120);
        System.out.println(Utils.arratToString(array));
        System.out.println(numSubArrayWithSum_930.numSubarraysWithSum_V1(array,2));
    }
}
