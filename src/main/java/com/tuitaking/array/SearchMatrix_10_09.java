package com.tuitaking.array;

import java.util.UUID;

/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 *
 * 给定target=20，返回false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchMatrix_10_09 {
    // 下面的方法主要能用于是个二位数组，切数组的行和列都是大于1的情况
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        if(matrix[0].length==0){
            return false;
        }
        if(matrix[0][0]>target){
            return false;
        }
        int col=0,row=0;
        int[][] index=new int[matrix.length][matrix[0].length];
        while (true){
            if(matrix[row][col]==target){
                return true;
            }
            if(index[row][col]==1){
                break;
            }
            index[row][col]=1;
            if(row<matrix.length && row-1>0){
               if(matrix[row][col]<target){
                   col++;
               }else if(matrix[row][col]>target){
                   col--;
               }
           }
           if(col<matrix.length){
               if(matrix[row][col]<target){
                   row++;
               }else  if(matrix[row][col]>target){
                   row--;
               }
           }
        }
        return false;
    }

    //v1
    public boolean searchMatrix_v1(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=0;
        while (row>=0 &&col<matrix[row].length ){ // 开始将col<matrix[row].length写在row>=0的前面，容易造成数组溢出！
            if(matrix[row][col]==target){
                return true;
            }else  if(matrix[row][col]<target){
                col++;
            }else {
                row--;
            }
        }
        return  false;
    }
}
