package com.tuitaking.point2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 限制：
 * 1 <= target <= 10^5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContinuousSequence_57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int sum = 1;
        int start = 1;
        for (int i = 2; i < target / 2 + 2; i++) {
            sum += i;
          if (sum > target) {
              while (sum > target) {
                    sum -= start;
                    start++;
               }
            }
            if (sum == target) {
                int[] res1 = new int[i - start + 1];
                for (int j = start; j < i+1; j++) {
                    res1[j - start] = j;
                }
                if(res1.length>1){
                    res.add(res1);
                }
                sum -= start;
                start++;

            }
        }
      return res.toArray(new int[res.size()][]);
    }
    // 和为n(n+1)/2
    public int[][] findContinuousSequence_leetcode(int target) {
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
