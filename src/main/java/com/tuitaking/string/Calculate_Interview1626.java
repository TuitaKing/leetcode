package com.tuitaking.string;


import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculator-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Calculate_Interview1626 {
    // 将-法作为加法的变种，最后将数据全部加起来就是结果
    public static int calculate(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack();
        int ans = 0, i = 0;
        while(i < cs.length){
            if(cs[i] == ' ') {i++;continue;}
            char tmp = cs[i];
            if(tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-'){
                i++;
                while(i < cs.length && cs[i] == ' ') i++;
            }
            int num = 0;
            while(i < cs.length && Character.isDigit(cs[i])){
                num = num * 10 + cs[i] - '0';
                i++;
            }
            switch(tmp){
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);
        }
        while(!st.isEmpty()) ans += st.pop();
        return ans;
    }

 // todo 逆波兰
//
//    private int calaulate_v2(String str){
//        Stack<String> stack=new Stack<>();
//        int start=0;
//        while (start<str.length()){
//           StringBuilder sb=new StringBuilder();
//           if(Character.isDigit(str.charAt(start))){
//               while (Character.isDigit(str.charAt(start))){
//                   sb.append(str.charAt(start));
//                   start++;
//               }
//               stack.push(sb.toString());
//           }else {
//               switch (str.charAt(start)){
//                   case '(':continue;break;
//                   case ')':continue;break;
//                   case '-':
//               }
//           }
//
//
//        }
//    }
    public static void main(String[] args) {
        String str="3-2*2";
        System.out.println(calculate(str));
    }
}
