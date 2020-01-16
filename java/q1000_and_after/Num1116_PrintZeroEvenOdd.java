package q1000_and_after;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Num1116_PrintZeroEvenOdd {

    private int n;
    private volatile int counter = 0;

    // three semaphore as lock
    private Semaphore zeroOne = new Semaphore(1);
    private Semaphore oddOne = new Semaphore(0);
    private Semaphore evenOne = new Semaphore(0);


    public Num1116_PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            zeroOne.acquire();
            counter++;
            if (counter > n) {
                // release the lock to terminate the thread
                oddOne.release();
                evenOne.release();
                return;
            }
            printNumber.accept(0);
            // awake proper printing thread
            if (counter % 2 == 0) {
                evenOne.release();
            } else {
                oddOne.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            evenOne.acquire();
            if (counter > n) return;

            printNumber.accept(counter);
            zeroOne.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            oddOne.acquire();
            if (counter > n) return;

            printNumber.accept(counter);
            zeroOne.release();
        }
    }
}
