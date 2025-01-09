# Singleton 과 Thread safe

### 📌Singleton 과 Thread-Safe

- `Singleton` 은 애플리케이션 전역에서 하나의 인스턴스만 유지하기 위한 디자인 패턴이다.
- `스레드 안정성`(Thraed-Safe)은 다중 스레드 환경에서도 프로그램이 예측 가능한 방식으로 동작하도록 보장하는 것을 의미한다.

**🔻Race Codition**

- Race Codition은 여러 프로세스 또는 스레드가 동시에 하나의 자원에 접근하기 위해 경쟁하는 상태를 의미한다.
- 싱글톤은 전역적으로 하나의 인스턴스만 존재해야 하므로, 멀티스레드 환경에서는 인스턴스를 생성하는 과정에서 Race Condition 문제가 발생할 수 있다.

### 📌Thread Safe Test

**🔻Case1**

```java
public class Counter implements Runnable {

    // ...

    @Override
    public void run() {
        this.increment();
        System.out.println("Value for Thread After increment : " + Thread.currentThread().getName() + " " + this.getCount());
        this.decrement();
        System.out.println("Value for Thread After decrement : " + Thread.currentThread().getName() + " " + this.getCount());
    }
}
```

```java
public class RaceConditionDemo {
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
```

<img src="/img/UnThreadsafe.png" width="">

**🔻Case2**

```java
public class Counter implements Runnable {

    // ...

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
```

<img src="/img/Threadsafe.png" width="">