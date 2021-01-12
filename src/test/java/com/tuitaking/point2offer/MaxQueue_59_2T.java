package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * ["MaxQueue","max_value","pop_front","max_value","push_back","max_value","pop_front","max_value","pop_front","push_back","pop_front","pop_front","pop_front","push_back","pop_front","max_value","pop_front","max_value","push_back","push_back","max_value","push_back","max_value","max_value","max_value","push_back","pop_front","max_value","push_back","max_value","max_value","max_value","pop_front","push_back","push_back","push_back","push_back","pop_front","pop_front","max_value","pop_front","pop_front","max_value","push_back","push_back","pop_front","push_back","push_back","push_back","push_back","pop_front","max_value","push_back","max_value","max_value","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","push_back","push_back","pop_front","max_value","pop_front","max_value","max_value","max_value","pop_front","push_back","pop_front","push_back","push_back","pop_front","push_back","pop_front","push_back","pop_front","pop_front","push_back","pop_front","pop_front","pop_front","push_back","push_back","max_value","push_back","pop_front","push_back","push_back","pop_front"]
 * [[],[],[],[],[46],[],[],[],[],[868],[],[],[],[525],[],[],[],[],[123],[646],[],[229],[],[],[],[871],[],[],[285],[],[],[],[],[45],[140],[837],[545],[],[],[],[],[],[],[561],[237],[],[633],[98],[806],[717],[],[],[186],[],[],[],[],[],[],[268],[],[29],[],[],[],[],[866],[],[239],[3],[850],[],[],[],[],[],[],[],[310],[],[674],[770],[],[525],[],[425],[],[],[720],[],[],[],[373],[411],[],[831],[],[765],[701],[]]
 */
public class MaxQueue_59_2T {
    @Test
    public void test(){
        MaxQueue_59_2 maxQueue_59_2=new MaxQueue_59_2();
        MaxQueue maxQueue=new MaxQueue();
        String[] populate=new String[]{"max_value","pop_front","max_value","push_back","max_value","pop_front","max_value","pop_front","push_back","pop_front","pop_front","pop_front","push_back","pop_front","max_value","pop_front","max_value","push_back","push_back","max_value","push_back","max_value","max_value","max_value","push_back","pop_front","max_value","push_back","max_value","max_value","max_value","pop_front","push_back","push_back","push_back","push_back","pop_front","pop_front","max_value","pop_front","pop_front","max_value","push_back","push_back","pop_front","push_back","push_back","push_back","push_back","pop_front","max_value","push_back","max_value","max_value","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","push_back","push_back","pop_front","max_value","pop_front","max_value","max_value","max_value","pop_front","push_back","pop_front","push_back","push_back","pop_front","push_back","pop_front","push_back","pop_front","pop_front","push_back","pop_front","pop_front","pop_front","push_back","push_back","max_value","push_back","pop_front","push_back","push_back","pop_front"};
        String[] populate1=new String[]{"max_value","pop_front","pop_front","max_value","max_value","pop_front","pop_front","push_back","pop_front","pop_front","max_value","push_back","max_value","push_back","push_back","max_value","pop_front","pop_front","push_back","push_back","push_back","push_back","push_back","pop_front","pop_front","push_back","pop_front","max_value","max_value","max_value","max_value","pop_front","max_value","pop_front","push_back","push_back","pop_front","pop_front","pop_front","push_back","max_value","pop_front","push_back","pop_front","pop_front","push_back","max_value","push_back","push_back","pop_front","pop_front","max_value","pop_front","push_back","push_back","pop_front","push_back","pop_front","max_value","push_back","max_value","max_value","pop_front","push_back","pop_front","push_back","push_back","max_value","max_value","max_value","pop_front","max_value","pop_front","push_back","push_back","pop_front","max_value","push_back","pop_front","pop_front","pop_front","push_back","push_back","push_back","max_value","pop_front","push_back","push_back","max_value","max_value","pop_front","pop_front","max_value","pop_front","max_value","pop_front","max_value","push_back","max_value"};
        int[] data=new int[]{0,0,0,46,0,0,0,0,868,0,0,0,525,0,0,0,0,123,646,0,229,0,0,0,871,0,0,285,0,0,0,0,45,140,837,545,0,0,0,0,0,0,561,237,0,633,98,806,717,0,0,186,0,0,0,0,0,0,268,0,29,0,0,0,0,866,0,239,3,850,0,0,0,0,0,0,0,310,0,674,770,0,525,0,425,0,0,720,0,0,0,373,411,0,831,0,765,701,0};
        int[] data1=new int[]{0,0,0,0,0,0,0,0,450,0,0,0,717,0,567,383,0,0,0,673,689,636,473,674,0,0,706,0,0,0,0,0,0,0,0,718,608,0,0,0,172,0,0,837,0,0,756,0,756,126,0,0,0,0,538,6,0,737,0,0,383,0,0,0,898,0,426,636,0,0,0,0,0,0,54,573,0,0,534,0,0,0,783,940,377,0,0,565,586,0,0,0,0,0,0,0,0,0,63,0};
        int i=0;
        for(String s:populate1){
            switch (s){
                case "max_value":
                    if(maxQueue_59_2.max_value()!=maxQueue.max_value()){
                        System.out.println("asdasdas");
                    };
                    break;
                case "pop_front":
                    if(maxQueue_59_2.pop_front()!=maxQueue.pop_front()){
                        System.out.println("asdasd");
                    };

                    break;
                case "push_back":
                    maxQueue.push_back(data1[i]);
                    maxQueue_59_2.push_back(data1[i]);
                    break;
            }
            i++;
        }
     }
}
