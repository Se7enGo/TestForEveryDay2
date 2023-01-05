package day0803;

import java.util.concurrent.locks.ReentrantLock;

public class MainTest implements Runnable {

    static ReentrantLock reentrantLock1 = new ReentrantLock();
    static ReentrantLock reentrantLock2 = new ReentrantLock();
    int lock = 0;

    public MainTest(int lock) {
        this.lock = lock;
    }

    public MainTest() {
    }

    @Override
    public void run() {

        try {
            if (lock == 1) {
                try {
                    reentrantLock1.lockInterruptibly();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock2.lockInterruptibly();

            } else {
                try {
                    reentrantLock2.lockInterruptibly();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            // 线程被打断之后 所占用的资源也是会被释放掉
            // 下面的代码是为了以防万一，最终也会执行一个释放资源的动作
            if (reentrantLock1.isHeldByCurrentThread()) {
                System.out.println(Thread.currentThread().getId() + "释放 reentrantLock1");
                reentrantLock1.unlock();
            }
            if (reentrantLock2.isHeldByCurrentThread())
                System.out.println(Thread.currentThread().getId() + "释放 reentrantLock2");
                reentrantLock2.unlock();
            System.out.println(Thread.currentThread().getId() + "线程退出");
        }

    }


    // 开启两个线程，这两个线程 分别取拿一把锁，稍后去请求另外一把锁
    // 会造成死锁现象
    public static void main(String[] args) {
        MainTest m1 = new MainTest(1);
        MainTest m2 = new MainTest(2);

        Thread rt1 = new Thread(m1);
        Thread rt2 = new Thread(m2);

        rt1.start();
        rt2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DeadLockChecker.check();
    }

    /**
     * java 内置了dump 命令 ，jps 查看所有运行中的线程  ,jstack + 线程号  可以查看线程状态 是否死锁
     * 界面化的 查询命令为 jconsole
     */
/*
    public static void main(String[] args) {

        MainTest mainTest = new MainTest();

        new Thread(()->{
            try {
                mainTest.reentrantLock1.lockInterruptibly();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                mainTest.reentrantLock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                mainTest.reentrantLock2.lockInterruptibly();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                mainTest.reentrantLock1.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }*/


}
