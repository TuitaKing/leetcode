package com.tuitaking.current;

import java.security.PrivateKey;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 两个xian
public class PrintDifference {
    private int n;
    private  ReentrantLock lock=new ReentrantLock();
    private AtomicBoolean atomicBoolean=new AtomicBoolean(true);
    public PrintDifference(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            lock.lock();
            while (atomicBoolean.get()){
                printFoo.run();
                atomicBoolean.getAndSet(false);
            }
            lock.unlock();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            lock.lock();;
            while (!atomicBoolean.get()){
                printBar.run();
                atomicBoolean.getAndSet(true);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintDifference printDifference=new PrintDifference(5);
        ExecutorService ex=Executors.newFixedThreadPool(5);
        for(int i = 0 ;i<5;i++){
            ex.execute(()-> {
                try {
                    printDifference.bar(()-> System.out.println("bar"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            ex.execute(()-> {
                try {
                    printDifference.foo(()-> System.out.println("foo"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        Thread.sleep(1000);
    }
}
