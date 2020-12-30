package com.tuitaking.everyDay;

/**
 * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalRectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int max=0;
       for(int row=0;row<matrix.length;row++){
           for(int col=0;col<matrix[0].length;col++){
                //选择所有1 开始
               if(matrix[row][col]==1){
                   int current=0;
                   //选择某一个作为开始
                   for(int i=row;i<matrix.length;i++){
                       for(int j = col;j<matrix[0].length;j++){
                           if(matrix[row][col]==1){
                               current++;
                           }else {

                           }
                       }
                   }
                   max = Math.max(current,max);
               }
           }
       }
       return max;
    }
}
