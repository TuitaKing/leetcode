package com.tuitaking.point2offer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords_58 {
    public String reverseWords(String s) {
        if(s.length()==0){
            return s;
        }
        String[] arr=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i = 0 ; i <arr.length;i++){
            if(arr[arr.length-1-i].length()>0){
                sb.append((arr[arr.length-1-i]).trim()).append(" ");
            }
        }
        if(sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }

    public String reverseWords_leetcode(String s) {
        s = s.trim();
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = ss.length -1; i >= 0 ; i--) {
            if(!ss[i].equals("")){
                if(i == 0) {
                    sb.append(ss[i]);
                } else {
                    sb.append(ss[i]).append(" ");
                }
            }

        }
        return sb.toString();
    }

}
