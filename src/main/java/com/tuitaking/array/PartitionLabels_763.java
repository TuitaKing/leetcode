package com.tuitaking.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionLabels_763 {
    public static void main(String[] args) {
       String str="a";
       PartitionLabels_763 partitionLabels_763=new PartitionLabels_763();
        System.out.println(partitionLabels_763.partitionLabels(str));
    }
    //遍历计算
    public List<Integer> partitionLabels(String str) {
        List<Integer> result=new ArrayList<>();
        int count=1;
        int last=0;
        for(int i = 0 ; i<str.length();i++){
            int left=i;
            int right=count-1;
            while (right<str.length()){
                if(str.charAt(left)==str.charAt(right)){
                    count=right+1;
                }
                right++;
            }
            if(left==count-1){
                result.add(count-last);
                last=left+1;
            }

        }
        return result;
    }


    public List<Integer> partitionLabels_v2(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

}
// 目前的想法就是首先找到当前值最远的长度，然后当前置下一个char就在最远长度的后面找，如果没有找到，继续下一个，
// 如果遇到最大的值比现在还打，则继续找，一直找到当前最大的那个位置


// 先记录每个字母出现的最远的位置，然后遍历数据，记录当前最远的位置，然后遍历数据，如果当前的位置和该最远位置相等，则记录下来