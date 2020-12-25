package com.tuitaking.tanxin;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)是正负交替出现的。相反, [1,4,7,2,5]和[1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 * 输入: [1,7,4,9,2,5]
 * 输出: 6 
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WiggleMaxLength_376 {
    // 0 , 0 ,0 不能通过,方向错了，不需要生成摇摆序列。
    public int wiggleMaxLength_err(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        if(nums.length==2){
            if(nums[0]==nums[1]){
                return 1;
            }else {
                return 2;
            }
        }
        int[] arr=new int[nums.length-1];
        int j = 0 ;
        for(int i = 1 ; i< nums.length;i++){
            arr[j]=nums[i]-nums[i-1];
            j++;
        }
        int res=0;
        int diff=2;
        int tmp=arr[0];
       for(int i = 1 ; i<arr.length;i++){
            if(tmp*arr[i]<0){
                diff++;
                tmp=arr[i];
            }
            res=Math.max(res,diff);
       }

        res=Math.max(res,diff);
       return res;
    }

    /**
     * 摇摆序列其实是个递增序列和递减序列的交叉点。
     * 需要求递增序列最大值，递减序列最小值
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }

        int pre=nums[1]-nums[0];
        int res=pre==0?1:2;
        for(int i = 2 ; i < nums.length;i++){
            int c=nums[i]-nums[i-1];
            if((c>0&&pre<=0)||(c<0&&pre>=0)){ // 这个判断语句～，我原来用的*，但是有个0在。。
                res++;
                pre=c;
            }
        }
        return res;
    }
}
