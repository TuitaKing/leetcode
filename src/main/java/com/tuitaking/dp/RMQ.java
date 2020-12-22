package com.tuitaking.dp;

public class RMQ{
    int[] nums;
    int[][] st;

    public RMQ(int[] nums){
        this.nums = nums;
        int n = nums.length;
        this.st = new int[n][(int)(Math.log(n + 1) / Math.log(2)) + 1];
        RMQInit();
    }

    private void RMQInit(){
        int n = nums.length;
        for(int i = 0; i < n; i++)  st[i][0] = nums[i];

        for(int j = 1; (1 << j) <= n; j++){
            for(int i = 0; i + (1 << j) - 1 < n; i++){
                st[i][j] = Math.max(st[i][j - 1], st[i + (1 << (j - 1) )][j - 1]);
            }
        }
    }

    public int query(int u, int v){
        return RMQQuery(u, v);
    }

    private int RMQQuery(int u, int v){
        int k = (int) (Math.log(v - u + 1) / Math.log(2));
        return Math.max(st[u][k], st[v - (1 << k) + 1][k]);
    }
}
