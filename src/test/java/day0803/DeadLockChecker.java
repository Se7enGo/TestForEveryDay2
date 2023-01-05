package day0803;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadLockChecker {


    private final static ThreadMXBean mbean = ManagementFactory.getThreadMXBean();

    final static Runnable deadlockCheck = new Runnable() {
        @Override
        public void run() {
            while (true) {
                long[] deadlockedThreadIds = mbean.findDeadlockedThreads();
                if (deadlockedThreadIds != null) {
                    ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockedThreadIds);
                    for (Thread t : Thread.getAllStackTraces().keySet()) {
                        for (int i = 0; i < threadInfos.length; i++) {
                            if (t.getId() == threadInfos[i].getThreadId()) {
                                t.interrupt();
                            }
                        }
                    }
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    };


    public static void check(){
        Thread thread = new Thread(deadlockCheck);
        thread.setDaemon(true);
        thread.start();
    }

}
