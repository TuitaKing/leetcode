package com.tuitaking.array;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    public static void main(String[] args) {
       String str="a";
       PartitionLabels_763 partitionLabels_763=new PartitionLabels_763();
        System.out.println(partitionLabels_763.partitionLabels(str));
    }
    //遍历计算
    public List<Integer> partitionLabels(String str) {
        List<Integer> result=new ArrayList<>();
        int count=1;
        int last=0;
        for(int i = 0 ; i<str.length();i++){
            int left=i;
            int right=count-1;
            while (right<str.length()){
                if(str.charAt(left)==str.charAt(right)){
                    count=right+1;
                }
                right++;
            }
            if(left==count-1){
                result.add(count-last);
                last=left+1;
            }

        }
        return result;
    }
}
// 目前的想法就是首先找到当前值最远的长度，然后当前置下一个char就在最远长度的后面找，如果没有找到，继续下一个，
// 如果遇到最大的值比现在还打，则继续找，一直找到当前最大的那个位置