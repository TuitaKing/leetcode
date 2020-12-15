package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class FindNumberIn2DArray_04T {

    @Test
    public void findNumberIn2DArrayT(){
        FindNumberIn2DArray_04 findNumberIn2DArray_04=new FindNumberIn2DArray_04();
        int[][] matrix=new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Assert.assertTrue(findNumberIn2DArray_04.findNumberIn2DArray(matrix,5));
        int[][] matrix_1=new int[][]{{1,2},{3,4}};
        Assert.assertTrue(!findNumberIn2DArray_04.findNumberIn2DArray(matrix_1,5));
        int[][] matrix_2=new int[][]{};
        Assert.assertTrue(!findNumberIn2DArray_04.findNumberIn2DArray(matrix_2,5));
    }
}
