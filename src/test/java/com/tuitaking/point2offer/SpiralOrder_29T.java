package com.tuitaking.point2offer;

import org.junit.Test;

public class SpiralOrder_29T {
    @Test
    public void test(){
        SpiralOrder_29 spiralOrder_29=new SpiralOrder_29();
//        spiralOrder_29.spiralOrder(new int[][]{
//                { 1, 2, 3 },
//                { 4, 5, 6 },
//                { 7, 8, 9 }
//        });
        spiralOrder_29.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}
