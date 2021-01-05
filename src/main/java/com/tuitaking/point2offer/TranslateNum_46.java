package com.tuitaking.point2offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum_46 {
    // 没有合理利用前面的数
    public int translateNum(int num) {
       int res=0;
       boolean max=false;
       while (num>0){
           int tmp=num%100;
           if(tmp>25){
               if(!max){
                res++;
               }
               // 345 45 34
               num/=10;
               max=true;
           }else {
               if(num>9){
                   res+=2;
               }
               num/=100;
               max=false;
           }

       }
       return res==0?1:res;
    }
    // 用动态规划试一试
    public int translateNum_v1(int num) {
        int one=1;
        int second=1;
        int low=num%10;
        while (num>0){
            num/=10;
            int high=num%10;
            int tmp=high*10+low;
            int curr=one;
            if(tmp>=10&&tmp<=25){
                curr=one+second;
            }
            second=one;
            one=curr;
            low=high;
        }
        return one;
    }
//    int a = 1, b = 1, x, y = num % 10;
//        while(num != 0) {
//        num /= 10;
//        x = num % 10;
//        int tmp = 10 * x + y;
//        int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
//        b = a;
//        a = c;
//        y = x;
//    }
//        return a;


}
