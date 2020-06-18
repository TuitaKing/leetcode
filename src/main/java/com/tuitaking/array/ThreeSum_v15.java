package com.tuitaking.array;

import com.tuitaking.dp.ClimbStairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lijing
 */
public class ThreeSum_v15 {
    public static void main(String[] args) {
        int[] data = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum_v15 threeSum_v15 = new ThreeSum_v15();
        List<List<Integer>> result = threeSum_v15.threeSum_v2(data, 0);
        System.out.println(result);
    }

    // 某些特殊的情况不能通过 {0,0,0,0}
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
//        是否有必要检验三个数的时候的情况
//        if (nums.length == 3) {
//            List<Integer> list = new ArrayList<>();
//            int sum=0;
//            for (Integer i : nums) {
//              sum+=i;
//              list.add(i);
//            }
//            if(sum==target){
//              result.add(list);
//            }
//            return result;
//        }
        Arrays.sort(nums);
        int left = 0;
        // 固定一个位置即left，然后使用mid 和right查找
        while (nums[left] < target || left < (nums.length - 2)) {
            int mid = left + 1;
            while (left > 0 && nums[mid + 1] == nums[mid]) {
                mid++;
            }
            int right = nums.length - 1;
            // 如果最左两边的数大于target，则不需要再往右边移动了
            if (nums[left] + nums[mid] > target) {
                return result;
            }
            while (mid < right) {
                while (nums[left] + nums[mid] + nums[right] > target && mid < right) {
                    right--;
                    while (nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                while (nums[left] + nums[mid] + nums[right] < target && mid < right) {
                    mid++;
                    while (nums[mid] == nums[mid - 1]) {
                        mid++;
                    }
                }
                if (nums[left] + nums[mid] + nums[right] == target && mid < right) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    result.add(list);
                    mid++;
                }
            }
            while (left < nums.length - 2 && nums[left + 1] == nums[left]) {
                left++;
            }
            left++;
        }
        return result;
    }

    public List<List<Integer>> threeSum_v2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        // 如果第一个数就大于target，则没有继续比较的必要了
        int left = 0;
        while (left < nums.length - 2) {
            if (nums[left] > target) {
                return result;
            }
            int mid = left + 1;
            int right=nums.length-1;
            // 过滤掉左边相同的数

            while (mid<right){
                while (mid<right&&mid>left+1&&nums[mid]==nums[mid-1]){
                mid++;
                 }
                if(mid<right&&nums[left]+nums[mid]+nums[right]>target){
                    right--;
                    continue;
                }
                if(mid<right&&nums[left]+nums[mid]+nums[right]<target){
                    mid++;
                    continue;
                }
                if(mid<right&&nums[left]+nums[mid]+nums[right]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    result.add(list);
                    mid++;
                }

            }
            while (left<nums.length-2&&nums[left]==nums[++left]){
//                left++;
            }

        }
        return result;
    }

    public List<List<Integer>> threeSum_v3(int[] nums,int targets){
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = targets-nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    // leetcode 最快写法
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue) {
                minValue = v;
            }
            if (v > maxValue) {
                maxValue = v;
            }
            if (v > 0) {
                posSize++;
            } else if (v < 0) {
                negSize++;
            } else {
                zeroSize++;
            }
        }
        if (zeroSize >= 3) {
            res.add(Arrays.asList(0, 0, 0));
        }
        if (negSize == 0 || posSize == 0) {
            return res;
        }
        if (minValue * 2 + maxValue > 0) {
            maxValue = -minValue * 2;
        } else if (maxValue * 2 + minValue < 0) {
            minValue = -maxValue * 2;
        }

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0) {
                        poses[posSize++] = v;
                    } else if (v < 0) {
                        negs[negSize++] = v;
                    }
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp) {
                basej++;
            }
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1) {
                            res.add(Arrays.asList(nv, nv, pv));
                        }
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1) {
                            res.add(Arrays.asList(nv, pv, pv));
                        }
                    } else {
                        if (map[cv - minValue] > 0) {
                            res.add(Arrays.asList(nv, cv, pv));
                        }
                    }
                } else if (cv < nv) {
                    break;
                }
            }
        }
        return res;
    }
}
/**
 *
 * 主要的思路是先指定一个位置不动，用两个指针在剩下的数组中查找，要略过相同的数值
 *
 * */