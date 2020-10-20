package com.tuitaking.binary_search_algorithm;

/**
 * 面试题 10.05. 稀疏数组搜索 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * <p>示例1:
 *
 * <p>输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta" 输出：-1
 * 说明: 不存在返回-1。 示例2:
 *
 * <p>输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball" 输出：4
 * 提示:
 *
 * <p>words的长度在[1, 1000000]之间 通过次数8,315提交次数14,612
 * https://leetcode-cn.com/problems/sparse-array-search-lcci/
 */
public class FindString_Interview1005 {

  /**
   * 这种实现方式是二分查找，但是测试用例没法完全通过，这是个问题
   * @param words
   * @param s
   * @return
   */
  @Deprecated
  public int findString(String[] words, String s) {
    int len=words.length;
    if(len==0){
      return 0;
    }
    int left=0;
    while (words[left].length()==0){
      left++;
    }
    int right=words.length-1;
    while (words[right].length()==0){
      right--;
    }
    int mid;
    while (left<=right){
      mid=left+(right-left)/2;
      while (words[mid].length()==0 && mid<right){
        mid++;
      }

      if(words[mid].equals(s)){
        return mid;
      }
      if(words[mid].charAt(0)>s.charAt(0)){
        right=mid-1;
        while (left<right&&words[right].length()==0){
          right--;
        }
      }else {
        left=mid+1;
        while (left<right&&words[left].length()==0){
          left++;
        }
      }
    }
    return -1;
  }

  /**
   * 解法一是按照Start和end来做的操作，这次使用mid来做，减少变量的判断
   * @param words
   * @param s
   * @return
   */
  public int findString_v2(String[] words,String s){
    int len=words.length;
    if(len==0){
      return -1;
    }
    int start=0,right=len-1;
    int mid=0;
    while (start<=right){
      mid=start+(right-start)/2;
      
    }

    return -1;
  }


  public static void main(String[] args) {
    //  String[] words=new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
     String[] words=new String[]{"", "", "", "", "AbHSZkLKTnHBbchUaS", "", "", "", "", "", "", "", "", "", "", "", "Ag kFlfSmsAEMy", "", "AsKLCqP", "", "", "", "", "", "AwNHxnNNZG", "", "", "", "", "", "", "", "BPwnIg", "", "CTZVBhsbvQpKHn", "DbWXiVetWyFeDu", "", "", "", "", "DdVm", "", "", "", "", "EIXK", "EUzGOV", "", "FBLOHPrpE", "GHMqgmMCXLkEBgU", "", "HPDGLlVDt", "", "", "", "", "", "", "HfF", "", "", "", "ILzzRaXUzNieYll", "", "", "", "", "", "", "", "", "IXO", "", "", "", "", "JMsO", "", "", "", "", "", "", "", "", "", "", "", "JNqzgSHitHRhdauLMcJ", "", "JZkNLIvaG", "", "", "KwRVFXYVJiueHvDHRTaJ", "", "", "LDTWBS", "", "", "", "", "", "", "LYN", "", "", "", "", "", "", "", "LpgNAXXV cWNYTwxo", "", "", "", "", "", "", "", "", "", "LxWJTErsIjyXjfCqrK", "", "", "", "", "", "", "", "", "MlJUQNiISaxtt", "", "", "", "", "", "", "", "", "", "", "O", "", "", "", "", "", "", "", "OHyIQptaYAfinbkjT", "", "", "", "", "", "", "", "", "", "", "", "OcQIESYXEmdykm", "", "", "", "", "", "", "", "", "Ol utzavtJOrPIK", "", "", "", "", "QLy", "", "", "", "", "", "QQZriWTlYYJgdlWl", "", "", "", "", "", "QhHySgWDIJwFtYP", "", "", "", "", "", "", "", "", "", "QiqwcedXKkVHDulp", "", "", "", "", "", "QtSvWSREnaYrrscc", "RHHeBMEnG nUX", "", "", "", "", "", "", "", "", "", "S", "", "", "", "", "", "", "", "", "", "SoULoFHOumjYMArBdiW", "", "", "", "", "SqHyxrJVNkrNaZG", "", "", "", "", "", "", "", "ThyUiuy", "", "", "Tu ac", "", "", "", "", "", "", "", "", "", "UGoOqhdXVzKl", "", "", "", "", "UbmA", "", "", "", "", "", "", "", "", "", "", "UsJhUmDujiOTntftsx", "", "", "", "", "", "", "", "", "", "", "V", "", "", "", "", "", "", "", "WEHisFZW wgmmVL", "", "", "", "", "", "", "", "", "", "", "", "WayOichMZsXpvJF", "", "WxVmzLgGjGlZOJwdzRd", "", "", "WzMjbVe WqjHOZJi", "", "", "", "", "", "", "", "", "", "", "", "XBVQZDHQT", "", "", "", "", "", "XMnsPtB AuMzDv", "", "XRNgMvqmhfjSfVVOP", "", "", "", "", "", "", "", "", "", "XYNh", "", "", "", "YfT", "", "", "", "", "", "", "", "", "", "", "", "amPIKYDmkUtUtFznRSvy", "", "", "", "", "", "", "", "", "", "bSs H MHwtgkOUzc", "", "", "", "cZhtYPrq ZpxZ", "", "", "", "", "", "", "dUGjmZGq", "e", "", "", "", "", "", "", "", "", "", "eWp", "epctu", "", "", "", "", "", "", "", "", "ezTPGIKrUmY", "", "", "", "", "", "", "", "", "", "", "fDnxFNxYyzUdQLc", "", "", "", "", "", "", "fFq", "", "", "", "", "", "", "", "", "", "", "fVjbEkHHU", "", "", "", "", "", "", "fux", "", "", "", "", "", "", "", "", "", "", "fwNIhmjYGktBo", "", "", "", "", "", "", "gEw", "", "", "hCisHtVxXZLjazN", "", "", "iqtlVbWLc", "", "", "jgLIRdgwDIaXioxoQkJn", "", "jpfhmJLfe", "", "", "", "kJEFz", "", "", "", "", "", "", "", "", "", "", "kKGFNPRtWNMY", "", "", "", "", "", "", "", "kXsm YJ", "", "", "", "kxjNfp c", "", "", "", "", "lnHVOerQcvgQEbBH", "", "", "", "", "", "mBsZUwwGmIsTwBUG", "", "mDMENtWiZwu", "", "miuxyF VvYebav", "", "", "", "", "", "nMWP", "", "", "", "", "", "", "", "", "", "", "", "nVbrbTsffMvICzx", "", "", "", "nYQuyy", "", "neMPLcFrptsISrhXBWe", "", "", "", "", "", "", "", "", "", "oAhJcIL", "", "", "", "", "ptybFCyrvqgy", "", "", "", "qVMPHyOgzIexxZ", "", "", "", "", "", "", "", "qvxuleCVWTYeboMK", "qyJLPQMBUuEEkhI", "", "", "", "", "", "", "", "", "", "", "rOsUPq", "", "", "", "sp v", "tjABXGFKaX", "", "", "", "", "", "", "", "", "uCFtpnikffzpIGynu", "", "", "uUOuBVKFxs", "", "", "", "", "", "", "ukVV", "", "", "", "", "uoRyNsvADRrPlF", "", "", "vJEsAKrSc jrBnvb", "", "", "", "", "", "", "", "", "", "", "wKjM", "", "", "", "", "", "", "", "", "wfWltxcuOFs", "", "", "", "", "", "", "", "wrjXviwslafTEBrLBDcQ", "", "", "", "", "", "", "", "", "", "", "xqhYBOAEpUzGUDG", "", "", "", "", "", "", "", "", "", "", "y", "", "yEvRmNbkvfELjCvG", "", "", "", "", "", "", "z NBqViMo", "", "", "", "zhEOGXTiOsTMbzW", "", "", "", "", "", "zuaVLjhQhNdg"};
    String s="WEHisFZW wgmmVL";
    // String s="ta";
    FindString_Interview1005 findString_interview1005=new FindString_Interview1005();
    System.out.println(findString_interview1005.findString(words,s));
  }
}
