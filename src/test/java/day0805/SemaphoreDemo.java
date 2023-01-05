package day0805;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable{

    // 初始化一个锁容器，可以进来5个线程申请到锁
    final Semaphore semaphore = new Semaphore(5);
    @Override
    public void run() {
        try {
            // 请求获取一把锁
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "获取到锁！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 释放掉锁
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        // pool 里的进程不是 守护线程 ，那么使用完成了之后线程就会处于等待 挂起 状态
        ExecutorService service = Executors.newFixedThreadPool(20);
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for (int i = 0;i< 20 ;i ++ ){
            service.submit(semaphoreDemo);
        }
    }
}
