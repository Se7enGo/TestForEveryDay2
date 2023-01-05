package day0517;

public class TestMain {

    public static Object c = new Object();

    public static TestThread t1 = new TestThread("t1");
    public static TestThread t2 = new TestThread("t2");

    static class TestThread extends Thread{

        public String name;

        public TestThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {

            synchronized (c){
                System.out.println(Thread.currentThread().getName() + "  run ");
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

       /* t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        System.out.println( "t1 resume");
        t2.resume();
        System.out.println( "t2 resume");
        t1.join();
        t2.join();*/
        int pos = 9 + 8;
        int zeroNumPos = Integer.numberOfLeadingZeros(pos);
        System.out.println(zeroNumPos);
        int idx = (0x80000000 >>> zeroNumPos) ^ pos;

        System.out.println(0x80000000 >>> zeroNumPos );
        System.out.println(Math.pow(2,31));
        System.out.println(idx);

    }
}
