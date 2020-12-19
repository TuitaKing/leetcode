package com.tuitaking.everyDay;

import org.junit.Assert;
import org.junit.Test;

import static com.tuitaking.common.Utils.printMatrix;

public class RotateMatrix_48T {
    @Test
    public void test(){
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix1=new int[][]{
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        printMatrix(matrix1);
        System.out.println("");
        RotateMatrix_48 matrix_48=new RotateMatrix_48();
        //matrix_48.rotate(matrix);
        matrix_48.rotate(matrix1);
        printMatrix(matrix1);
        Assert.assertEquals(1,1);
    }
}
