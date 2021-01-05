package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class TranslateNum_46T {
    @Test
    public void test(){
        TranslateNum_46 translateNum_46=new TranslateNum_46();
        for(int i = 9 ; i< 1000000;i++){
//            System.out.println(i);
//        int i=1110;
            Assert.assertEquals(translateNum_46.translateNum_v1(i),translateNum(i));;
        }

    }























    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

}
