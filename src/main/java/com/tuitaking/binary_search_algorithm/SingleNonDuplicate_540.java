package com.tuitaking.binary_search_algorithm;

public class SingleNonDuplicate_540 {

    // 选取中间位置的index的值，该index 前面有index个数字，
    // 如果index 为奇数且index-1的数和index中的数相同，则说明前面有偶数个数字，只会存在mid后面。如果index+1和index中的值相等，说明在mid前面
    // 如果index 为偶数且渝index-1的数相等，那么说明前面的数字是奇数个，在mid前面，



    public static int singleNonDuplicate(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int start=0;
        int end=nums.length;
        int mid=0;
        while (start<=end){
            mid=(end+start)/2;
            if(mid==nums.length-1 || mid==0){
                break;
            }
            if(mid%2==0){
                if(nums[mid]==nums[mid-1]){
                    end=mid;
                }else if(nums[mid]==nums[mid+1]){
                    start=mid;
                }else {
                    return nums[mid];
                }
            }else if(mid%2!=0){
                if(nums[mid]==nums[mid-1]){
                    start=mid;
                }else if(nums[mid]==nums[mid+1]){
                    end=mid;
                }else {
                    return nums[mid];
                }
            }
        }
        return nums[mid];
    }

    public int singleNonDuplicate_v2(int[] nums){
        int res = 0;
        for(int i : nums) {
            res ^= i;
        }
        return res;
    }

    public int singleNonDuplicate_leetcode_v1(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }

    public int singleNonDuplicate_leetcode_v2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }






    public static void main(String[] args) {
        int[] arrat=new int[]{1,1,2,2,3,3,4,8,8};
        int[] arrat1=new int[]{3,3,7,7,10,10,11};
        System.out.println(SingleNonDuplicate_540.singleNonDuplicate(arrat));
    }
}
