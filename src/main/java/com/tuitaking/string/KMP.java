package com.tuitaking.string;

public class KMP {
    public static void main(String[] args) {
        String test="aaaa";
        String pa="baaa";
        System.out.println(findKmp(test,pa));
    }

    public static int findKmp(String test, String pattern) {

        int n=test.length();
        int m=pattern.length();
        if(m>n){
            return -1;
        }
        if(m==0){
            return 0;
        }
        int[] fail=findKmpFail(pattern);
        // j为在test上移动的指针
        int j=0;
        // k为在pattern上移动的指针，也就是适配的指针
        int k=0;

        while (j<n){
            // 如果当前的值相等，则继续往下
            if(test.charAt(j)==pattern.charAt(k)){
                if(k==m-1)return j-m+1;
                j++;
                k++;
            }else if(k>0){
                // 如果不相等，且已经有适配的值，则移动
                k=fail[k-1];
            }else {
                j++;
            }
        }
        return -1;
    }
    public static int[] findKmpFail(String pattern){
        int m=pattern.length();
        int[] fail=new int[m];
        int j=1;
        int k=0;
        while (j<m){
            // 如果相等则都记录当前的位置的为k+1的值，k+1的值表示为匹配的下一个值
            if(pattern.charAt(j)==pattern.charAt(k)){
                fail[j]=k+1;
                j++;
                k++;
            }else if(k>0){
                k=fail[k-1];
            }else {
                j++;
            }
        }
        return fail;
    }
}
