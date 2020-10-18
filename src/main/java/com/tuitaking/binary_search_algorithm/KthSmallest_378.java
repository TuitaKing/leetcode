package com.tuitaking.binary_search_algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * 示例：
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallest_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length;
        if(m==0){
            return 0;
        }
        int n=matrix[0].length;
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>(m*n, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                integers.add(Integer.valueOf(matrix[i][j]));
            }
        }

        for (int i = 0; i < k - 1; i++) {
            integers.poll();
        }
        int res=integers.poll();
        return res;
    }

    public int kthSmallest_v2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

//    public int kthSmallest_v3(int[][] matrix,int k){
//        int n= matrix.length;
//        if(n==0){
//            return 0;
//        }
//        int m=matrix[0].length;
//
//    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        KthSmallest_378 kthSmallest_378 = new KthSmallest_378();
        int res = kthSmallest_378.kthSmallest(matrix, 8);
        System.out.println(res);
    }
}
