package com.tuitaking.string;

import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        Executors.newCachedThreadPool().execute(()->{
            System.out.println("hello");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
