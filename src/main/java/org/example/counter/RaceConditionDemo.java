package org.example.counter;

public class RaceConditionDemo {
    //psvm
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread r1 = new Thread(counter, "Thread-1");
        Thread r2 = new Thread(counter, "Thread-2");
        Thread r3 = new Thread(counter, "Thread-3");

        r1.start();
        r2.start();
        r3.start();
    }
}

/**
 * [Result_1]
 *
 * Value for Thread After increment : Thread-1 1
 * Value for Thread After increment : Thread-2 2
 * Value for Thread After increment : Thread-3 3
 * Value for Thread After decrement : Thread-1 2
 * Value for Thread After decrement : Thread-3 0
 * Value for Thread After decrement : Thread-2 1
 *
 * [Result_2]
 *
 * Value for Thread After increment : Thread-1 1
 * Value for Thread After decrement : Thread-1 0
 * Value for Thread After increment : Thread-3 1
 * Value for Thread After decrement : Thread-3 0
 * Value for Thread After increment : Thread-2 1
 * Value for Thread After decrement : Thread-2 0
 */