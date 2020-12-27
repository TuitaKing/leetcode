package com.tuitaking.race.r20201227;

import java.util.HashMap;
import java.util.List;

/**
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 *
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 * 示例 3：
 *
 * 输入：s = "MerryChristmas"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "AbCdEfGh"
 * 输出：true
 */
public class HalvesAreAlike {

 public  boolean halvesAreAlike(String s) {
     if(s.length()==0){
         return false;
     }
     HashMap<Character,Integer> count=new HashMap<>();
     count.put('a',1);
     count.put('e',1);
     count.put('i',1);
     count.put('o',1);
     count.put('u',1);
     count.put('A',1);
     count.put('E',1);
     count.put('I',1);
     count.put('O',1);
     count.put('U',1);
     int mid=s.length()/2;
     int right=mid;
     int leftC=0;
     int rightC=0;
     for(int i = 0 ; i <mid;i++){
         if(count.get(s.charAt(i))!=null){
             leftC++;
         }
//         right+=i;
         if(count.get(s.charAt(right+i))!=null){
             rightC++;
         }
     }
     return leftC==rightC;
    }

//    public static void main(String[] args) {
//        System.out.println(halvesAreAlike("book"));
//        System.out.println(halvesAreAlike("textbook"));
//        System.out.println(halvesAreAlike("MerryChristmas"));
//        System.out.println(halvesAreAlike("AbCdEfGh"));
//    }
}
