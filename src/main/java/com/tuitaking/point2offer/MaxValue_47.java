package com.tuitaking.point2offer;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *  [1,3,1],
 *  [1,5,1],
 *  [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxValue_47 {
    public int maxValue(int[][] grid) {
     int row=0,col=0;
     int[][]  res=new int[grid.length][grid[0].length];
     res[0][0]=grid[0][0];
     while (row<grid.length) {
         while (col<grid[0].length){
            if(row==0){
                res[row][col]=grid[row][col]+(col==0?0:res[row][col-1]);
            }else {
                res[row][col]=grid[row][col]+Math.max(res[row-1][col],(col==0?0:res[row][col-1]));
            }
            col++;
         }
         row++;
         col=0;
      }
     return res[res.length-1][res[0].length-1];
    }
}
