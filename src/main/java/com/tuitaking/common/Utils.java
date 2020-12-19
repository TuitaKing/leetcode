package com.tuitaking.common;


import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String arratToString(int[] arr){
        StringBuilder sb=new StringBuilder("[");
        for(int i :arr){
            sb.append(i+",");
        }
       sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    public static final void printMatrix(int[][] matrix){
        for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
