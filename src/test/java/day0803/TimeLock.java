package day0803;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {

    public static final ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)){
                Thread.sleep(6000);
            }else {
                System.out.println( Thread.currentThread().getName() + "do not get the lock !");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 如果被当前线程所持有，才可以进行锁的释放，如果没有持有 则会报出 IllegalMonitorStateException
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        TimeLock tl = new TimeLock();

        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);

        t1.start(); t2.start();

    }
}
