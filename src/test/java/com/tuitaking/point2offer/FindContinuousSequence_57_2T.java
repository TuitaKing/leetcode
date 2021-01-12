package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence_57_2T {
    @Test
    public void test(){
        FindContinuousSequence_57_2 findContinuousSequence_57_2=new FindContinuousSequence_57_2();
        findContinuousSequence_57_2.findContinuousSequence(1);
        for(int i = 1 ; i < 1000;i++){
            Assert.assertArrayEquals(findContinuousSequence_57_2.findContinuousSequence(i),findContinuousSequence(i));
        }

    }



    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
