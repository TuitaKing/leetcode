package com.tuitaking.point2offer;

import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring_48 {
    // 开始忘记记录当前如果满足的时候也是需要计算最大值的 比如ab
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> count=new HashMap<>();
        int start=0;
        int end=0;
        int res=1;
        while (end<chars.length){
            char curr=chars[end];
            count.put(curr,count.getOrDefault(curr,0)+1);
            if(count.get(curr)>1){
                res=Math.max(res,end-start);
                for(int i=start;i<end;i++){
                    count.put(chars[i],count.getOrDefault(chars[i],0)-1);
                    if(chars[i]==curr){
                        start=i+1;
                        break;
                    }
                }
            }else   res=Math.max(res,end-start+1);
            end++;
        }

        return res;
    }
}
