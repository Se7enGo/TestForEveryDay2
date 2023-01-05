package day0808;

public class TestMain {

    public static void main(String[] args) {

        Integer a = new Integer(1);
        Integer b = new Integer(2);


        Integer c = a; Integer d = c;
        System.out.println(  "d ========"  + d);
        System.out.println(  "c ========"  + c);
        a = new Integer(3) ;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("d ======== " + d);
        System.out.println("c ========"  + c);
        System.out.println(c != d);

    }
}
