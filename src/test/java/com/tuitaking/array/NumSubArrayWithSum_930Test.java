package com.tuitaking.array;

import com.tuitaking.common.MockUtil;
import com.tuitaking.common.Utils;
import org.junit.Test;

public class NumSubArrayWithSum_930Test {
    @Test
    public void test(){
        NumSubArrayWithSum_930 numSubArrayWithSum_930=new NumSubArrayWithSum_930();
        int[] array=new int[]{1,2,2,4,5,5};// MockUtil.mockArray(10,120);
        System.out.println(Utils.arratToString(array));
        System.out.println(numSubArrayWithSum_930.subarraySum(array,9));
    }
}
