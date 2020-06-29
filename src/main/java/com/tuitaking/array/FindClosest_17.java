package com.tuitaking.array;

/**
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 *
 * words.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindClosest_17 {
    public int findClosest(String[] words, String word1, String word2) {
        if(word1==null || word2==null || word1.length()==0||word2.length()==0 || words==null ||words.length==0 ){
            return words.length;
        }
       int len=Integer.MAX_VALUE;
       int firstCount=1;
       int lastCount =1;
       int first=0;
       int last=Integer.MAX_VALUE;
       for(int i = 0  ; i < words.length;i++){
           // 首先找到合适的长度，最长的计算
           if(words[i].equals(word1)){
               if(firstCount==1){
                   firstCount--;
                   first=i;
               }
              if(firstCount==0){
                  first=i;
              }
           }
           if(words[i].equals(word2)){
               if(lastCount==1){
                   lastCount--;
                   last=i;
               }
               if(lastCount==0){
                   last=i;
               }
           }
           if(lastCount==0 && firstCount==0){
                if(first>last){
                    lastCount++;
                }else {
                    firstCount++;
                }
                len=Math.min(len,first>last?first-last:last-first);
           }
       }
       return len;
    }
    // 最快的解法，开始也打算这么干，但是没有写出来。其实不需要过多关注count的信息
    public int findClosest_v2(String[] words, String word1, String word2) {
        int step = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            if(s.equals(word1)){
                if(index2 != -1){
                    step = Math.min(step, i - index2);
                }
                if(step == 1){
                    return 1;
                }
                index1 = i;
            } else if(s.equals(word2)){
                if(index1 != -1){
                    step = Math.min(step, i - index1);
                }
                if(step == 1){
                    return 1;
                }
                index2 = i;
            }
        }
        return step;
    }

}

// 想法是用双子座
