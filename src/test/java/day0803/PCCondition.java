package day0803;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PCCondition {

    private PriorityQueue<Integer> queue=new PriorityQueue<>(10);
    private ReentrantLock lock=new ReentrantLock();
    private Condition notFull=lock.newCondition();
    private Condition notEmpty=lock.newCondition();
    public static void main(String[] args) {

        PCCondition  object=new PCCondition();
        Producer producer=object.new Producer();

        Producer producer2=object.new Producer();
        Consumer consumer=object.new Consumer();

        Consumer consumer2=object.new Consumer();
        producer.start();
        producer2.start();
        consumer.start();
        consumer2.start();
    }

    class Consumer extends Thread
    {
        @Override
        public void run()
        {
            consume();
        }
        private void consume()
        {
            while(true)
            {
                lock.lock();
                try {
                    while(queue.size()==0)
                    {
                        try {
                            System.out.println(Thread.currentThread().getName() + "队列为空");
                            notEmpty.await();

                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();

                        }
                    }
                    queue.poll();
                    notFull.signal();
                    System.out.println(Thread.currentThread().getName() + "取走一个元素,还有："+queue.size());

                }finally
                {
                    lock.unlock();
                }
            }
        }

    }

    class Producer extends Thread
    {
        @Override
        public void run()
        {
            produce();
        }
        private void produce()
        {
            while(true)
            {
                lock.lock();
                try{
                    while(queue.size()==10)
                    {

                        try {
                            System.out.println(Thread.currentThread().getName() + "队列已经满了");
                            notFull.await();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    notEmpty.signal();
                    System.out.println(Thread.currentThread().getName() + "向队列中插入一个元素，长度为"+queue.size());
                }finally
                {
                    lock.unlock();
                }
            }
        }
    }

}
