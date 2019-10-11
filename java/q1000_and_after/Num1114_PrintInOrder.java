package q1000_and_after;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Num1114_PrintInOrder {
    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        foo.third(new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        });
        foo.second(new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        });
        foo.first(new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        });
    }
}

class Foo {
    AtomicInteger a = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (!a.compareAndSet(0, 1)) {
                this.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            this.notify();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (!a.compareAndSet(1, 2)) {
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            this.notify();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (!a.compareAndSet(2, 3)) {
                this.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            this.notify();
        }
    }
}

class Foo2 {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo2() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }
}

