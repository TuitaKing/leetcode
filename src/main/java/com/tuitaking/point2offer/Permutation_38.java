package com.tuitaking.point2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutation_38 {
    public String[] permutation(String s) {
        char[] arr=s.toCharArray();
        List<String> resList=new ArrayList<>();
        helper(arr,0,resList);
        String[] res=new String[resList.size()];
        for(int i = 0 ; i<resList.size();i++){
            res[i]=resList.get(i);
        }
        return res;
    }
    public void helper(char[] arr,int from,List<String> res){
        if(from==arr.length-1){
            res.add(new String(arr));
            return;
        }
        Set<Character> set=new HashSet<>();
        for(int i = from ; i <arr.length;i++){
                  if(set.contains(arr[i])) {
                    continue;
                  }
                  set.add(arr[i]);
                  swap(arr,from,i);
                  helper(arr, from+1, res);
                  swap(arr,i,from);
              }
    }
    private void swap(char[] arr,int i ,int j){
       char tmp=arr[i];
       arr[i]=arr[j];
       arr[j]=tmp;
    }



    // leetcode 最快解法，
    List<String> ans=new ArrayList<>();
    char[] chars;
    public String[] permutation_v1(String s) {
        chars =s.toCharArray();
        Arrays.sort(chars);
        dfs(0);
        return ans.toArray(new String[ans.size()]);
    }
    void dfs(int index){
        if(index==chars.length){
            ans.add(new String(chars));
        }else{
            for (int i = index; i < chars.length; i++) {
                if(canSwap(index,i)){
                    swap(index,i);
                    dfs(index+1);
                    swap(index,i);
                }
            }
        }
    }
    // 是否需要swap这个操作很魔性
    boolean canSwap(int a,int b){
        for (int i = a; i < b; i++) {
            if(chars[i]==chars[b])return false;
        }
        return true;
    }
    void swap(int a,int b){
        char tmp=chars[a];
        chars[a]=chars[b];
        chars[b]=tmp;
    }
}
