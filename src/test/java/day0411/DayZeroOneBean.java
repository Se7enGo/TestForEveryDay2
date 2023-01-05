package day0411;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class DayZeroOneBean {

    public void dosomething(){

        short i = innerClass.i;

        System.out.println("innerClass. i =============" + i);
    }

    private static class innerClass{

        public static final short i = 1;
        static {
            System.out.println("=         ================================= innerClass 加载了！！！！");
        }
    }

    @Bean
    @Lazy
    public innerClass innerClassBean(){

        return new innerClass();
    }
}
