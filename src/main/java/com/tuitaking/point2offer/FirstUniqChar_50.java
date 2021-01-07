package com.tuitaking.point2offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar_50 {
    public char firstUniqChar(String s) {
        if(null == s || s.length()==0){
            return ' ';
        }
        Map<Character,int[]> count=new HashMap<>();
        for(int i = 0 ; i<s.length();i++){
            count.put(s.charAt(i),new int[]{count.getOrDefault(s.charAt(i),new int[]{0,0})[0]+1,i});
        }
        int index=Integer.MAX_VALUE;
        char res=' ';
        for(Character c:count.keySet()){
            if(count.get(c)[0]==1){
                if(index!=Math.min(index,count.get(c)[1])){
                    index=count.get(c)[1];
                    res=c;
                }
            }
        }
        return res;
    }
    // 需要注意index 在循环中的判断 ， 应该将此类判断作为一个范本，index<s.length()
    public char firstUniqChar_v1(String s) {
        if(null == s || s.length()==0){
            return ' ';
        }
        int[] count=new int[26];
        int index=0;
        for(int i = 0 ; i <s.length();i++){
            count[s.charAt(i)-'a']++;
            if(count[s.charAt(i)-'a']>1){
                while (index<s.length()&&count[s.charAt(index)-'a']>1){
                    index++;
                }
            }
        }
        if(index==s.length()-1 && count[s.charAt(s.length()-1)-'a']>1){
            return ' ';
        }
        return s.charAt(index);
    }
    // 使用String自身的特性
    public char firstUniqChar_v2(String s) {
        if(null == s || s.length()==0){
            return ' ';
        }
        int index=s.length();
        for(int i = 0 ; i<s.length();i++){
            int first=s.indexOf(s.charAt(i));
            if(first==s.lastIndexOf(s.charAt(i))){
                if(i<index){
                    index=i;
                }
            }
        }
        return index==s.length()?' ':s.charAt(index);
    }

    // 优化V2 使用a-z做循环
    public char firstUniqChar_vFast(String s) {
        int minIndex = s.length();
        for (int i='a'; i<='z'; i++) {
            int x = s.indexOf(i);
            if (x>=0 && x==s.lastIndexOf(i)) {
                if (minIndex > x) {
                    minIndex = x;
                }
            }
        }
        return (minIndex==s.length())?' ':s.charAt(minIndex);
    }
}
