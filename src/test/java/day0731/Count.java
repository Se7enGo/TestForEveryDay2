package day0731;

public class Count {

    TestForLock lock = new TestForLock();
    public void print() throws InterruptedException {
        lock.lock();
        doAdd();
        lock.unlock();
    }
    public void doAdd() throws InterruptedException {
        lock.lock();
        //do something
        lock.unlock();
    }

    public static void main(String[] args) {
        Count count = new Count();
        try {
            count.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
