package com.tuitaking.fun;

public class Test {
    public void hello(){
        System.out.println("hello");
    }
    @org.junit.Test
    public void test() throws InterruptedException {
        Thread thread=new Thread(this::hello);
        thread.start();;
        Thread.sleep(100);
    }
}
