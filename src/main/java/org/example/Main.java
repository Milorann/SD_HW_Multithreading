package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<String> data = Arrays.asList(
            "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d",
            "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d",
            "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d",
            "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d");

    public static void main(String[] args) {
        System.out.println("\nОтвет: " + doParallelWork(data));
    }

    public static int doParallelWork(List<String> data) {
        AtomicCounter cnt = new AtomicCounter();
        // В вычислениях будет учатвовать main и два ForkJoinPool.commonPool-worker.
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
        data.parallelStream().forEach(str -> {
            cnt.increment(str.length());
            System.out.println(Thread.currentThread().getName());
        });
        return cnt.getCount().get();
    }
}