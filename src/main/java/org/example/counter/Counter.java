package org.example.counter;

public class Counter implements Runnable {
    // 상태를 가지도록 상태값 추가
    private int count = 0;

    public void increment() {
        ++count;
    }

    public void decrement() {
        --count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        synchronized (this) {
            this.increment();
            System.out.println("Value for Thread After increment : " + Thread.currentThread().getName() + " " + this.getCount());
            this.decrement();
            System.out.println("Value for Thread After decrement : " + Thread.currentThread().getName() + " " + this.getCount());
        }
    }
}
