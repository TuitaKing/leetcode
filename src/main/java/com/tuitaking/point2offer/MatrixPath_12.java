package com.tuitaking.point2offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatrixPath_12 {
    Map<String, Boolean> maps;
    // 里面的==0的判断可以添加在helper中
    public boolean exist(char[][] board, String word) {
        maps = new HashMap<>();
        char[] array = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == array[0]) {
                    maps.put(row+"&"+col, true);
                    if((helper(board, row== 0 ? 1 : (row - 1), col, array, 1) ||
                            helper(board, row + 1, col, array, 1) ||
                            helper(board, row, col == 0 ? 1:(col - 1) , array, 1) ||
                            helper(board, row, col + 1, array, 1))){
                        return true;
                    }
                    maps.remove(row+"&"+col);
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int row, int col, char[] array, int index) {
        if(index==array.length){
            return true;
        }
        if (row == board.length || col == board[row].length || (maps.get(row+"&"+col) != null && maps.get(row+"&"+col)) || board[row][col] != array[index]) {
            return false;
        }
        if (board[row][col] == array[index]) {
            maps.put(row+"&"+col, true);
             if((helper(board, row== 0 ? 1 : (row - 1), col, array, index + 1) ||
                    row!=0&& helper(board, row + 1, col, array, index + 1)   ||
                    helper(board, row,  col == 0 ? 1:(col - 1), array, index + 1) ||
                    col!=0&&helper(board, row, col + 1, array, index + 1))){
                 return true;
             }
            maps.remove(row+"&"+col);
        }
        return false;
    }
}
