package com.tuitaking.common;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MockUtil {
  private static final Random random = ThreadLocalRandom.current();

  public static int[] mockArray(int size){
    return  mockArray(size,100);
  }

  public static int[] mockArray(int size,int max){
    int[] arr=new int[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(max);
    }
    return arr;
  }

 public static ListNode mockListNode(int size,int max){
      ListNode root=new ListNode(-1);
      ListNode tail=root;
    for(int i = 0 ; i < size;i++){
      ListNode node=new ListNode(random.nextInt(max));
      tail.next=node;
      tail=tail.next;
    }
    return root.next;
  }

  public static int[] mockSortedArray(int size){
      int[] randomArray=mockArray(size,100);
      Arrays.sort(randomArray);
      return randomArray;
  }
  public static ListNode mockSortedList(int size){
      int[] a=mockSortedArray(size);
      ListNode root=new ListNode(-1);
      ListNode tail=root;
      for(int i = 0 ; i < size;i++){
          ListNode node=new ListNode(a[i]);
          tail.next=node;
          tail=tail.next;
      }
      return root.next;
  }




}

