package day0523;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestForJuc {

    static ExecutorService threadPool =  Executors.newFixedThreadPool(10);
    @Test
    public void JucThreadPool(){
        //手写FutureTask()

        // Park()基于cpu    Wait() 基于线程

    }
}
