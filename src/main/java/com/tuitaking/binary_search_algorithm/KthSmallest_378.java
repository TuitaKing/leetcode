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
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>(matrix.length*matrix[0].length, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                integers.add(Integer.valueOf(matrix[i][j]));
            }
        }

        for (int i = 0; i < k - 1; i++) {
            integers.poll();
        }
        int res=integers.poll();
        return res;
    }

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
