package com.tuitaking.array;

public class NumSubArrayWithSum_930 {
    public int numSubarraysWithSum(int[] array, int target) {
        if(array.length<1){
            return 0;
        }
        int len=0;
        int sum=0;
        for(int i = 0 ; i< array.length;i++){
            sum=array[i];
            if(sum==target){
                len++;
            }
            for(int second=i+1;second<array.length;second++){
                sum+=array[second];
                 if(sum==target){
                     len++;
                 }
                 if(sum>target){
                     break;
                 }
            }
        }
        return len;
    }
}
