package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Num1114_PrintInOrder {

    AtomicInteger atomicInteger = new AtomicInteger(1);
    Object lock = new Object();

    public Num1114_PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (atomicInteger.get() != 1) {
                lock.wait();
            }
            printFirst.run();
            atomicInteger.setPlain(2);
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (atomicInteger.get() != 2) {
                lock.wait();
            }
            printSecond.run();
            atomicInteger.setPlain(3);
            lock.notifyAll();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (atomicInteger.get() != 3) {
                lock.wait();
            }
            printThird.run();
            atomicInteger.setPlain(1);
            lock.notifyAll();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
    }
}

class SolutionUseSemaphore {
    Semaphore run2, run3;

    public SolutionUseSemaphore() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        printThird.run();
    }
}

class SynchronizedSolution {

    int count = 0;

    public SynchronizedSolution() {
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {


        printFirst.run();
        count++;
        this.notifyAll();

    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        while (count != 1) {
            this.wait();
        }
        printSecond.run();
        count++;
        this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        while (count != 2) {
            this.wait();
        }
        printThird.run();
        count++;
    }
}

class CASSolution {

    AtomicInteger count = new AtomicInteger();

    public CASSolution() {
        count.set(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        while (!count.compareAndSet(0, 4)) {
            // printFirst.run() outputs "first". Do not change or remove this line.
        }
        printFirst.run();
        count.set(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!count.compareAndSet(1, 4)) {
            // printSecond.run() outputs "second". Do not change or remove this line.
        }
        printSecond.run();
        count.set(2);

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!count.compareAndSet(2, 4)) {
            // printThird.run() outputs "third". Do not change or remove this line.
        }
        printThird.run();
        count.set(3);
    }
}