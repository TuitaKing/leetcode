package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class MajorityElement_39T {
    @Test
    public void test() {
        MajorityElement_39 majorityElement_39=new MajorityElement_39();
       Assert.assertEquals(majorityElement_39.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}),2);
       Assert.assertEquals(majorityElement_39.majorityElement(new int[]{8,8,7,7,7}),7);
}
}