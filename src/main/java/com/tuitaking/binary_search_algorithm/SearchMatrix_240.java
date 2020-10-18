package com.tuitaking.binary_search_algorithm;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
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
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchMatrix_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0){
            return false;
        }
        int n=matrix[0].length;
        // 从左下角开始
        int row=m-1,col=0;
        while(row>=0 && col<=n-1){
            if(matrix[row][col]>target){
                row--;
            }else if(matrix[row][col]<target){
                col++;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        SearchMatrix_240 searchMatrix_240=new SearchMatrix_240();
        System.out.println(searchMatrix_240.searchMatrix(matrix,9));
    }
}
