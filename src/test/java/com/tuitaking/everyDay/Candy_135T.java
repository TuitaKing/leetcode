package com.tuitaking.everyDay;

import com.tuitaking.common.MockUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Candy_135T {
    @Test
    public void test(){
        Candy_135 candy_135=new Candy_135();
        for(int i = 3 ; i<100;i++){
            int[] temp= MockUtil.mockArray(i);
            System.out.println(Arrays.toString(temp));
//            System.out.println(candy_135.candy_2(temp));
            Assert.assertEquals(candy_135.candy(temp),candy_135.candy_v1(temp));
        }
        candy_135.candy(new int[]{33, 88, 61, 10, 74});
    }
}
