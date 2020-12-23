package com.tuitaking.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers_448T {
    @Test
    public void test(){
        FindDisappearedNumbers_448 disappearedNumbers_448=new FindDisappearedNumbers_448();
        List<Integer> res=disappearedNumbers_448.findDisappearedNumbers(new int[]{2,1});
        System.out.println(Arrays.toString(res.toArray()));
    }
}
