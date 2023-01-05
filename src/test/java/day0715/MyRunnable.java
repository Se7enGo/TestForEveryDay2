package day0715;

public class MyRunnable implements Runnable {

    public void run() {
        methodOne();
    }

    public void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 =
                MySharedObject.sharedInstance;

        //... do more with local variables.

        methodTwo();
        System.out.println("methodOne 里 localVariable1" + localVariable1);

        System.out.println("methodOne 里 localVariable2" + localVariable2.member1);
        System.out.println("methodOne 里 localVariable2" + localVariable2.member2);
        System.out.println("methodOne 里 localVariable2" + localVariable2.object2);
        System.out.println("methodOne 里 localVariable2" + localVariable2.object4);

    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);

        //... do more with local variable.
        System.out.println("methodTwo 里 localVariable1" + localVariable1);
    }


    public static void main(String[] args) {

        new Thread(new MyRunnable()).start();


    }
}