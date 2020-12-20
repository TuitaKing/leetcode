package com.tuitaking.everyDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        List<Character> windows=new ArrayList<Character>();
        char[] sa=s.toCharArray();
        for(int i = 0 ;i<s.length();i++){
            if(windows.contains(sa[i])){
               for(int j= windows.indexOf(sa[i])+1;j<windows.size();j++){
                   if(windows.get(j)<sa[i]){
                       windows.remove(windows.indexOf(sa[i]));
                       windows.add(sa[i]);
                       break;
                   }
               }
            }else {
                windows.add(sa[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(Character character:windows){
            sb.append(character);
        }

        return sb.toString();
    }

    public String removeDuplicateLetters_v1(String s) {
        LinkedList<Character> deque = new LinkedList<>();
        int[] count = new int[26];
        boolean[]exists = new boolean[26];
        // 初始化
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        // 遍历s并入栈
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!exists[temp - 'a']){
                while (!deque.isEmpty() && deque.getLast() > temp && count[deque.getLast() - 'a'] > 0){
                    exists[deque.getLast() - 'a'] = false;
                    deque.removeLast();
                }
                deque.add(temp);
                exists[temp - 'a'] = true;
            }
            count[temp - 'a']--;
        }
        //返回
        StringBuilder res = new StringBuilder();
        for(char ch : deque){
            res.append(ch);
        }
        return res.toString();
    }

}
