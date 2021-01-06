package com.tuitaking.string;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome_5 {
    public String longestPalindrome(String s) {
      char[] chars=s.toCharArray();
      int max=0;
      String res=null;
      for(int i = 0 ; i < chars.length;i++){
          int left=i-1;
          int right=i+1;
          while (left>0 && chars[left]==chars[i]){
              left--;
          }
          while (right<s.length() && chars[right]==chars[i]){
              right++;
          }
          while (left>=0 && right<chars.length){
              if(chars[left]==chars[right]){
                  left--;
                  right++;
              }else break;
          }
          if(left>=0 && right<chars.length){
              if(right-left>max){
                res=s.substring(left,right-1);
                  max=right-left;
              }
          }
      }
     return res;
    }
}
