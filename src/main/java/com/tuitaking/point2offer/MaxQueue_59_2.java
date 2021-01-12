package com.tuitaking.point2offer;

import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出:[null,-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxQueue_59_2 {
    LinkedList<Integer> data = new LinkedList<>();
    LinkedList<Integer> max = new LinkedList<>();

    public MaxQueue_59_2() {

    }

    public int max_value() {
        if (max.isEmpty()) {
            return -1;
        }
        return max.peek();
    }

    public void push_back(int value) {
        data.addLast(value);
        while (!max.isEmpty() && max.peekLast().compareTo(value) < 0) {
            max.pollLast();
        }
        max.addLast(value);

    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        if (data.peek().equals(max.peek())) {
            max.pollFirst();
        }
        return data.pollFirst();
    }

}
