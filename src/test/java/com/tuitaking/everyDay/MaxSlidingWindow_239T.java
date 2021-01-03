package com.tuitaking.everyDay;

import com.tuitaking.point2offer.MaxSlidingWindow_35;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_239T {
    @Test
    public void test(){
        MaxSlidingWindow_35 maxSlidingWindow_239=new MaxSlidingWindow_35();
        int[] temp=new int[]{1,3,-1,-3,5,3,6,7};
        Assert.assertArrayEquals(maxSlidingWindow_239.maxSlidingWindow(temp,3),maxSlidingWindow(temp,3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

}
