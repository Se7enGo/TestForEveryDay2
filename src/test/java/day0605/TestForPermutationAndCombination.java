package day0605;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestForPermutationAndCombination {


    @Test
    public void RepeatableCombination(){

//        int m = 10;
//        BigInteger n = BigInteger.ONE.multiply(BigInteger.TEN).divide(BigInteger.ONE.add(BigInteger.ONE));
//        BigInteger s =  BigInteger.ONE;

        int m = 5;
        int n =10;
        final Long s =new Long(1);
        //输出从n个数中可重复抽取m个数的所有组合个数
        //由可重复组合公式可以知道
        // Cnm可重复= C n+m-1|m = An+m-1 |m /Amm
        //则最后的结果等于
        //(n+m-1)! /m!/(n+m-1-m)!
        // Stream.iterate(s,t -> t.multiply(n.subtract(BigInteger.ONE))).limit(5).forEach(System.out::println);

        //long ss = factorial(n +m -1)/(factorial(m) * factorial(n -1)) ;
       // System.out.println(ss);
        long sum ;


    }

    public static long factorial(long number) {

        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}
