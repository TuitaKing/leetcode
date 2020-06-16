package com.tuitaking.string;

public class KMP {
    public static void main(String[] args) {
        String test="cabcabcdabcd";
        String pa="abcabcdabc";
        System.out.println(findKmp(test,pa));
    }

    public static int findKmp(String test, String pattern) {
        int n=test.length();
        int m=pattern.length();
        if(m==n) return 0;
        int[] fail=findKmpFail(pattern);
        int j=0;
        int k=0;
        while (j<n){
            if(test.charAt(j)==pattern.charAt(k)){
                if(k==m-1)return j-m+1;
                j++;
                k++;
            }else if(k>0){
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
