import java.util.concurrent.locks.ReentrantLock;

public class IncrementSynchronize {
    private int value = 0;
    Object x = new Object();
    private ReentrantLock lock = new ReentrantLock();

    public void getNextValue1() {
        synchronized (x) {
            value++;
        }
    }
    public synchronized void getNextValue2() {
        value++;
    }
    public void getNextValue3() {
        lock.lock();
        value++;
        lock.unlock();
    }
    public int getValue() {
        return value;
    }
    synchronized static void getNextValue4()
    {

    }
}