package com.javarush.test.level28.lesson06.home01;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Admin on 22.01.2017.
 */
public class MyThread extends Thread {

    private static AtomicInteger priority = new AtomicInteger();

    private void init()
    {
        priority.incrementAndGet();
        priority.compareAndSet(11, 1);

        int val = priority.get();
        if (this.getThreadGroup() != null)
            if (val > this.getThreadGroup().getMaxPriority())
                val = this.getThreadGroup().getMaxPriority();

        setPriority(val);
    }

    public MyThread()
    {
        init();
    }

    public MyThread(Runnable target) {
        super(target);
        init();
    }

    public MyThread(String name) {
        super(name);
        init();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        init();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        init();
    }
}
