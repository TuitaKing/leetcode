package com.tuitaking.fun;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 4, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class TestDequeVsLinkedList {
    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(TestDequeVsLinkedList.class.getSimpleName())
                .forks(4)
                .build();

        new Runner(opt).run();
    }
    @Benchmark
    public void array_100w() {
        int n=1000000;
        Deque<Integer> integers=new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
          integers.add(i);
        }
    }

    @Benchmark
    public void linked_100w() {
        int n=1000000;
        Deque<Integer> integers=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            integers.add(i);
        }
    }
    @Benchmark
    public void array_128w() {
        int n=1280000;
        Deque<Integer> integers=new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            integers.add(i);
        }
    }

    @Benchmark
    public void linked_128w() {
        int n=1280000;
        Deque<Integer> integers=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            integers.add(i);
        }
    }
}
