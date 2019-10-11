package q1000_and_after;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Num1115_PrintFooBarAlternately {

}

class FooBar {
    private int n;
    private AtomicBoolean atomicBoolean = new AtomicBoolean(true);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while(!atomicBoolean.get()) {
                    this.wait();
                }
                printFoo.run();
                atomicBoolean.set(false);
                this.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                while(atomicBoolean.get()) {
                    this.wait();
                }
                printBar.run();
                atomicBoolean.set(true);
                this.notify();
            }
        }
    }
}
