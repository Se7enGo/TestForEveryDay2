package day0411;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:../test-classes/applicationContext.xml")
public class TestForJUC {

    private ConcurrentLinkedQueue<Long> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    private CountDownLatch countDownLatch = new CountDownLatch(this.threadNum);

    private int threadNum = 150;

    private volatile int count = 0;

    private String usercode = "u1001";

    /*@Autowired
    private ProfitDetailService profitDetailService;*/


    @Test
    public void testForEquals(){
        String str = "23";
        System.out.println(Long.valueOf(str).equals(23) );
    }

    @Autowired
    private DayZeroOneBean dayZeroOneBean;

    @Test
    public void testForInnserClass(){

        dayZeroOneBean.dosomething();

        dayZeroOneBean.innerClassBean();

        dayZeroOneBean.innerClassBean();
    }


    @Test
    public void testForWait(){

        Integer i = new Integer(1);

        Thread t1 = new Thread(() ->{
             synchronized (i){

                 try {
                     i.wait();

                     System.out.println(new Date());
                 } catch (InterruptedException e) {
                     System.out.println("打扰我le");
                 }
             }
        });

        t1.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {

        }
        Thread t2 = new Thread(() ->{
            synchronized (i){

                i.notifyAll();
                System.out.println("起来干活了");
            }
        });

        t2.start();

    }

/*
    @Test
    public void testForDuoXiancheng(){

        for (int i = 0;i < this.threadNum;i++){
            new Thread(new ProfitAmount(usercode)).start();
            countDownLatch.countDown();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/

    @Test
    public void testForBinary(){

        int p = 6;
        int n = (p > 1) ? p - 1 : 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n = (n + 1) << 1;

        System.out.println(n);

        int STARTED= 1<< 2;
        int s = 5;
        System.out.println(Integer.toBinaryString(s  ));
        System.out.println(Integer.toBinaryString(s & STARTED));
        if ((s & STARTED) == 1){
            System.out.println(Boolean.valueOf(String.valueOf(s & STARTED)));
        }

    }
/*

    class ProfitAmount implements Runnable{

        private String usercode;

        public ProfitAmount(String usercode) {
            this.usercode = usercode;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BigDecimal amount = profitDetailService.getProfitAmount(this.usercode);
            System.out.println("usercode = " + this.usercode + " amount = " + amount);
        }


        public String getUsercode() {
            return usercode;
        }

        public void setUsercode(String usercode) {
            this.usercode = usercode;
        }
    }
*/

    //@Before
    public void initQueue() {

        //Stream.iterate(0l, a -> a + 1).limit(100000).parallel().forEach(i -> concurrentLinkedQueue.add(i));

    }

    /**
     * 生成一个 初始化数据库的sql文件
     */
    //@Test
    /*public void generateSQL() {

        *//**
         * LOAD DATA local INFILE 'e:/insert.sql' INTO TABLE tenmillion(`categ_id`, `categ_fid`, `SortPath`, `address`, `p_identifier`, `pro_specification`, `name`, `description`, `add_date`, `picture_url`, `thumb_url`, `shop_url`, `shop_thumb_url`, `brand_id`, `unit`, `square_meters_unit`, `market_price`, `true_price`, `square_meters_price`);
         * 注意字段不再以逗号分割，以\t分割，条记录以\r\n分割。结果我插入10次数据，100W平均只要1分钟搞定。
         *//*
        StringBuilder sb = new StringBuilder("");

        //生成 60 万笔订单
        List<Integer> codeList = Stream.iterate(100001, a -> a + 1).limit(600000).collect(Collectors.toList());
        // 生成 10 中商品号
        List<Integer> pCodeList = Stream.iterate(3001, a -> a + 1).limit(10).collect(Collectors.toList());

        // 生成随机的商品价格
        // 生成 10 个用户ID
        List<String> userList = Stream.iterate(1000, a -> a + 1).limit(10).map(a -> "u" + a).collect(Collectors.toList());

        Random random = new Random();
        int min = 1;
        int max = 10;

        double mind = 1.1;
        double maxd = 100000.1;

        Random doubleRandom = new Random(100000);

        codeList.stream().forEach(a -> {
            int randomInt = min + (int) (random.nextFloat() * (max - min));
            int nextrandomInt = min + (int) (random.nextFloat() * (max - min));
            sb.append(String.format("%s\t%s\t%s\t%s\t%s\t\r\n"
                    , a
                    , pCodeList.get(randomInt)
                    , ""
                    , (mind + (Double) (doubleRandom.nextDouble() * (maxd - mind)))
                    , userList.get(nextrandomInt)));
        });
        //finalString = finalString.substring(0,finalString.lastIndexOf(","));
        //sb.replace(sb.lastIndexOf(","),sb.lastIndexOf(","),";");
        String finalSqlString = sb.toString();

        File file = new File("C:\\Users\\Alex\\Desktop\\finalSql.sql");
        if (!file.exists()) {
            File parent = file.getParentFile();
            if (!parent.exists()) {
                file.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        OutputStreamWriter outputStream = null;
        char[] characters = new char[2048];
        int bb = 0;

        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new ByteArrayInputStream(finalSqlString.getBytes())));

        try {
            outputStream = new OutputStreamWriter(new FileOutputStream(file));
            while ((bb = isr.read(characters)) > 0) {
                outputStream.write(characters, 0, bb);
            }
            isr.close();
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
*/
    //@Test
    /*public void testForLocalTime() {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatTime = localDateTime.format(dtf);
        System.out.println(formatTime);
        // return formatTime;
    }*/


    //@Test
    public void test01() {
        for (int i = 0; i < threadNum; i++) {
            new Thread(new DoSomething("Name + " + i)).start();
            countDownLatch.countDown();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("一共取数 " + count + "次");
    }

    //@Test
    public void testVolatile() {

        this.threadNum = 2;
        for (int i = 0; i < threadNum; i++) {

            new Thread(new AddVolatileNum()).start();
            countDownLatch.countDown();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    private class AddVolatileNum implements Runnable {


        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 0;
            while (i++ <= 10000) {
                count++;
            }
        }
    }

    private class DoSomething implements Runnable {

        private String name;

        public DoSomething(String name) {
            this.name = name;
        }

        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            while (true) {
                if (count < 1000) {
                    count++;
                    long i = concurrentLinkedQueue.poll();

                    System.out.println("I am Thread " + name + " and I get Num " + i);
                } else {
                    return;
                }


            }

        }

        public long getAndSout() {
            if (!concurrentLinkedQueue.isEmpty()) {
                long i = concurrentLinkedQueue.poll();
                System.out.println("I am Thread " + name + " and I get Num " + i);

                return i;
            }
            return 0;
        }

    }


}
