package com.tuitaking.point2offer;

public class Fib_10 {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        int pre=0,res=1,next=1;
        for(int i = 2;i<=n;i++){
            res=(pre+next)%1000000007;
            pre=next;
            next=res;
        }
      return res;
    }
}
