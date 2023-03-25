package org.example;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment(int v) {
        count.addAndGet(v);
    }
}
