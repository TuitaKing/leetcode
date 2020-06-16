package com.tuitaking.array;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * <p>请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * <p>你可以假设 nums1 和 nums2 不会同时为空。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>nums1 = [1, 3] nums2 = [2]
 *
 * <p>则中位数是 2.0 示例 2:
 *
 * <p>nums1 = [1, 2] nums2 = [3, 4]
 *
 * <p>则中位数是 (2 + 3)/2 = 2.5
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays_4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // 确保nums1的长度始终小于nums2
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int num1Length = nums1.length;
    int num2Length = nums2.length;

    int totalLeft = (num2Length + num1Length + 1) / 2;
    // 在小的数组中查找
    int left = 0;
    int right = num1Length;
    // 这里的i 表示的分隔后的在nums1上的后一位，j表示nums2在分隔后的第一位，
    // i-1 就是nums1中的左边分隔最大的数，j-1 也是nums2左边分隔最大的数，需要保证的是
    // nums[i-1]<=nums[j] && nums[j-1] <=nums[i]
    while (left < right) {
      // 此处为二分的地方，保证时间复杂度O(log(m+n)),
      // 使用这种+1的方式，由于right-left>=1 所有i的值最小也为1，所以下面的i-1 不会出现越界。
      int i = left + (right - left + 1) / 2;
      int j = totalLeft - i;
      if (nums1[i - 1] > nums2[j]) {
        right = i - 1;
      } else {
        left = i;
      }
    }
    int i = left;
    int j = totalLeft - i;
    int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[left - 1];
    int nums1RightMin = i == num1Length ? Integer.MAX_VALUE : nums1[i];
    int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
    int nums2RightMin = j == num2Length ? Integer.MIN_VALUE : nums2[j];
    if ((num1Length + num2Length) / 2 == 1) {
      return Math.max(nums1LeftMax, nums2LeftMax);
    } else {
      return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
    }
  }

  public double findMedianSortedArrays1(int A[], int B[]) {
    // 奇偶数不会有影响，最后中位数就是平均值
    int m = A.length, n = B.length;
    int l = (m + n + 1) / 2;
    int r = (m + n + 2) / 2;

    return (findKthNum(A, B, 0, 0, l) + findKthNum(A, B, 0, 0, r)) / 2.0;
  }

  private double findKthNum(int[] A, int[] B, int Astart, int Bstart, int k) {
    int lenA = A.length;
    int lenB = B.length;
    if (Astart >= lenA) {
      return B[Bstart + k - 1];
    }
    if (Bstart >= lenB) {
      return A[Astart + k - 1];
    }
    if (k == 1) {
      return Math.min(A[Astart], B[Bstart]);
    }
    int minA = Integer.MAX_VALUE;
    int minB = Integer.MAX_VALUE;
    if (Astart + k / 2 - 1 < A.length) {
      // 如果这里超过了A数组的范围，那就说明A中有将A、B合并后一半以上的
      // 数，也就是说中位数肯定在A中。那后面的minB<minA(MAX_VALUE)，就会成立，从而舍弃B中的前一些无关的数
      minA = A[Astart + k / 2 - 1];
    }
    if (Bstart + k / 2 - 1 < B.length) {
      minB = B[Bstart + k / 2 - 1];
    }
    if (minA < minB) {
      return findKthNum(A, B, Astart + k / 2, Bstart, k - k / 2);
    } else {
      return findKthNum(A, B, Astart, Bstart + k / 2, k - k / 2);
    }
  }

  public double findMedianSortedArrays3(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    if (m > n) { // to ensure m<=n
      int[] temp = A;
      A = B;
      B = temp;
      int tmp = m;
      m = n;
      n = tmp;
    }
    int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
    while (iMin <= iMax) {
      int i = (iMin + iMax) / 2;
      int j = halfLen - i;
      if (i < iMax && B[j - 1] > A[i]) {
        iMin = i + 1; // i is too small
      } else if (i > iMin && A[i - 1] > B[j]) {
        iMax = i - 1; // i is too big
      } else { // i is perfect
        int maxLeft = 0;
        if (i == 0) {
          maxLeft = B[j - 1];
        } else if (j == 0) {
          maxLeft = A[i - 1];
        } else {
          maxLeft = Math.max(A[i - 1], B[j - 1]);
        }
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }

        int minRight = 0;
        if (i == m) {
          minRight = B[j];
        } else if (j == n) {
          minRight = A[i];
        } else {
          minRight = Math.min(B[j], A[i]);
        }

        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }
}
/** 找到中位数，如果是奇数个数据，则找到中间数，如果是偶数，则是中间两个数只和除以二 按照这个思路，在两个有序的数组中找到中位数，可以将两个数组分为两堆，左边一堆的最大值小于右边一堆的最小值 */
