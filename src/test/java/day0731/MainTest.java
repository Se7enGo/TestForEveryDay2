package day0731;

import java.util.concurrent.CopyOnWriteArrayList;

public class MainTest {

    /**
     * 这个方法验证了CopyOnWrite 什么时候会进行写入操作
     * @param args
     */
    public static void main(String[] args) {

        final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("no1");
        list.add("no2");
        list.add("no3");
        list.add("no4");
        list.add("no5");
        list.add("no6");
        list.add("no7");
        list.add("no8");
        list.add("no1");
        list.add("no2");
        list.add("no3");
        list.add("no4");
        list.add("no5");
        list.add("no6");
        list.add("no7");
        list.add("no8");
        list.add("no1");
        list.add("no2");
        list.add("no3");
        list.add("no4");
        list.add("no5");
        list.add("no6");
        list.add("no7");
        list.add("no8");
        list.add("no1");
        list.add("no2");
        list.add("no3");
        list.add("no4");
        list.add("no5");
        list.add("no6");
        list.add("no7");
        list.add("no8");
        list.add("no1");
        list.add("no2");
        list.add("no3");
        list.add("no4");
        list.add("no5");
        list.add("no6");
        list.add("no7");
        list.add("no8");

        for (String s : list){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.clear();
                }
            }).start();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }

        System.out.println(list);
    }
}
