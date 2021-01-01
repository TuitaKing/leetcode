package com.tuitaking.everyDay;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），
 * 和一个数n。能否在不打破种植规则的情况下种入n朵花？能则返回True，不能则返回False。
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPlaceFlowers_605 {
    //需要把这些代码全都弄在一个循环里。主要是判断是否为头尾节点，然后判断前后是否都是0
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==0){
            return false;
        }
        if(flowerbed.length==1){
            if(flowerbed[0]==1 && n>=1){
                return false;
            }else {
                return n<=1;
            }
        }
        if(flowerbed[0]==0 && flowerbed[1]==0){
            n--;
            flowerbed[0]=1;
        }
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0){
            n--;
            flowerbed[flowerbed.length-1]=1;
        }
        int zero=0;
        for(int i = 1 ; i < flowerbed.length ; i++){
            if(flowerbed[i]==0){
                zero++;
                if(zero==3){
                    n--;
                    zero=1;
                }
            }else {
                zero=0;
            }
        }
        return n<=0;
    }
    //
    public boolean canPlaceFlowers_v1(int[] flowerbed, int n) {

        for(int i = 0 ; i < flowerbed.length;i++){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1||flowerbed[i+1]==0)){
                flowerbed[i]=1;
                n--;
            }
        }
        return n<=0;
    }
}
