package com.tuitaking.point2offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k<= 20
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Robot_13 {
    HashMap<String,Boolean> maps =new HashMap<>();
    int m;
    int n;
        //   用map的时候会出现stackoverflow的问题用数组却不会
    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        int res=0;
        try{
           res= moveHelper(0,0,k);
        }catch (StackOverflowError e){
            e.printStackTrace();
        }
        maps=new HashMap<>();
        return res;
    }

    public int moveHelper(int row,int col,int k){
           if(row>m||col>n||row<0||col<0||maps.get(row+"$"+col)!=null){
             return 0;
           }
            maps.put(row+"$"+col,true);

        return  moveHelper(row+1,col,k)+
                       moveHelper(row-1,col,k)+
                       moveHelper(row,col+1,k)+
                       moveHelper(row,col-1,k)+1;



    }

    private int everyPointSum(int i){
        int res=0;
        while (i!=0){
            res+=i%10;
            i=i/10;
        }
        return res;
    }



    public int movingCount_v1(int m, int n, int k) {
        boolean[][] visit=new boolean[m][n];
        return helper(0,0,k,visit,m,n);
    }
    private int helper(int row,int col,int k,boolean[][] visit,int m , int n ){
        if(row>=m||row<0||col>=n||col<0||visit[row][col]||((everyPointSum(row)+everyPointSum(col))>k)){
            return 0;
        }
        visit[row][col]=true;
        return  helper(row+1, col, k, visit, m, n)+
                helper(row-1, col, k, visit, m, n)+
                helper(row, col+1, k, visit, m, n)+
                helper(row, col-1, k, visit, m, n)+1;
    }
}