package com.tuitaking.array;

import org.junit.Test;

public class SearchMatrix_10_09Test {

    @Test
    public void test(){
//       int[][] mat=new int[][]{{1,4,7,11,15},
//                               {2,5,8,12,19},
//                               {3,6,9,16,22},
//                               {10,13,14,17,24},
//                               {18,21,23,26,30}};
        int[][] mat=new int[][]{{-1}};
       SearchMatrix_10_09 matrix_10_09=new SearchMatrix_10_09();
       matrix_10_09.searchMatrix_v1(mat,5);
    }
}
