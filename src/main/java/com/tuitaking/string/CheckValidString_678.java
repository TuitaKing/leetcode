package com.tuitaking.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 (必须有相应的右括号 )。
 * 任何右括号 )必须有相应的左括号 (。
 * 左括号 ( 必须在对应的右括号之前 )。
 * *可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: True
 * 示例 2:
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 * 输入: "(*))"
 * 输出: True
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckValidString_678 {
    // 此种方法忽略了顺序的问题，比如*在（的右边就其实是没有意义的
    public boolean checkValidString_v1(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.addLast('(');
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    } else {
                        return false;
                    }
                    break;
                case '*':
                    stack.addFirst('*');
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        int any = 0;
        int left = 0;
        for (char c : stack) {
            switch (c) {
                case '(':
                    left++;
                    break;
                case '*':
                    any++;
                    break;
            }
        }
        return any >= left;
    }

    public boolean checkValidString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> tmp = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        while (!stack.isEmpty() && stack.peek() == '*') {
                            tmp.push(stack.poll());
                        }
                        if (!stack.isEmpty()) {
                            stack.poll();
                        } else {
                            tmp.poll();
                        }
                        while (!tmp.isEmpty()) {
                            stack.push(tmp.poll());
                        }

                    } else {
                        return false;
                    }
                    break;
                case '*':
                    stack.push('*');
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        int any = 0;
        int left = 0;
        for (char c : stack) {
            switch (c) {
                case '(':
                    left++;
                    if(any-left<0){
                        return false;
                    }
                    break;
                case '*':
                    any++;
                    break;
            }
        }
        return any >= left;
    }
    // 官方解答，开始也有想过是用Integer来判断，主要是他对）的处理
    public boolean checkValidString_leetcode(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        boolean res = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            }else if (s.charAt(i) == '*') {
                star.push(i);
            }else {
                if (!left.isEmpty()) {
                    left.pop();
                }else if(!star.isEmpty()) {
                    star.pop();
                }else {
                    return res = false;
                }
            }
        }
        while (!left.isEmpty()) {
            if (!star.isEmpty() && left.peek() < star.peek()) {
                star.pop();{}
                left.pop();
            }else{
                return res = false;
            }
        }
        return res;
    }
}
