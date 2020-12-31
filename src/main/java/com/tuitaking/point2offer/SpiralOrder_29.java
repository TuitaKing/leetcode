package com.tuitaking.point2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix =[[1,2,3,4],
 *               [5,6,7,8],
 *               [9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length<= 100
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder_29 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int[] res=new int[matrix.length*matrix[0].length];
        int left=0;
        int right=matrix[0].length-1;
        int up=0;
        int down=matrix.length-1;
        int row=0;
        int col=-1;
        int status=0;
        int index=-1;
        //使用状态机器，主要是方便自己思考，对比spiralOrder_v1的解法，
        // 其实本质上是一样的。惭愧
        while (left<=right||up<=down){
            if(index==res.length-1){
                break;
            }
            switch (status){
                // 状态0，从左边到右
                case 0:
                    while (++col<=right){
                        res[++index]=matrix[row][col];
                    }
                    col--;
                    status=1; // 改为从上往下
                    up++; // 顶层边框加一
                    break;
                // 状态1，从上到下
                case 1:
                    while (++row<=down){
                        res[++index]=matrix[row][col];
                    }
                    row--;
                    right--;
                    status=2;
                    break;
                // 状态2，从右边往左边
                case 2:
                    while (--col>=left){
                        res[++index]=matrix[row][col];
                    }
                    col++;
                    down--;
                    status=3;
                    break;
                // 状态3 ，从下往上
                case 3:
                    while (--row>=up){
                        res[++index]=matrix[row][col];
                    }
                    row++;
                    left++;
                    status=0;
                    break;

            }
        }
        return res;
    }

    public int[] leetcode_res(int[][] matrix){
        if(matrix.length == 0) return new int[0];
        int len = (Math.min(matrix.length, matrix[0].length)+1)/2;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[matrix.length * matrix[0].length];
        for (int l = 0; l < len; l++) {
            for (i = l, j = l; j < matrix[0].length - l; j++) {
                res[k++] = matrix[i][j];
            }
            if (i >= matrix.length - l - 1) break;
            for (i++, j--; i < matrix.length - l; i++) {
                res[k++] = matrix[i][j];
            }
            if (j < l + 1) break;
            for (i--, j--; j >= l; j--) {
                res[k++] = matrix[i][j];
            }
            for (i--, j++; i >= l + 1; i--) {
                res[k++] = matrix[i][j];
            }
        }
        return res;
    }
    //此解法和我的其实是一样的
    public int[] spiralOrder_v1(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }


}
