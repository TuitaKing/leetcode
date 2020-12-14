package com.tuitaking.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4]的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianFinder_295 {
    List<Integer> array;
    /** initialize your data structure here. */
    public MedianFinder_295() {
        array=new ArrayList<>();
    }

    public void addNum(int num) {
        array.add(num);
    }

    public double findMedian() {
        Collections.sort(array);
        //偶数，取两边
        if(array.size()%2==0){
            int left=array.get(array.size()/2);
            int right=array.get(array.size()/2-1);
            return (left+right)/2.0;
        }else {
            return array.get(array.size()/2);
        }
    }

    public static void main(String[] args) {
        MedianFinder_295 medianFinder_295=new MedianFinder_295();
        medianFinder_295.addNum(1);
        medianFinder_295.addNum(2);
        medianFinder_295.addNum(3);
        System.out.println(medianFinder_295.findMedian());
    }
}
