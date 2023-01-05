package day0731;

public class TestForLock {

    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException{
        System.out.println("lock拿到锁");
        while(isLocked){
            wait();
        }
        isLocked = true;
        System.out.println("lock释放锁");
    }
    public synchronized void unlock(){
        System.out.println("unlock拿到锁");
        isLocked = false;
        notify();
        System.out.println("unlock释放锁");
    }
}
