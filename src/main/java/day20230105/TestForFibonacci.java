package day20230105;

import java.util.Date;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 问题描述 有这么一个公式定义f(n) = f(n-1) + f(n-2)
 * 画出问题解决树 可以看出这个问题是这个问题需要看问题规模，也就是总问题拆分成子问题后的数量，
 * 再乘以每个问题的解决时间。显然这个问题如果画成递归树的话，显然是一个标准的二叉树，问题规模是指数级别的（2^n），
 * 只有加法操作则时间是o(1),那么时间复杂度就是2^n。这个时间是不可以接受的，观察递归树，可以发现有大量重复的计算，
 * 比如f(18)两次，f(17)三次，且f(18)的子树计算量占了一半，
 * 所以如果有备忘录则可以不用计算两遍/多遍。递归树上只会遍历f(k)，算法的时间复杂度缩减为o(n)，
 * 也就是解法思路中的关键之一--重叠子问题。
 * */
public class TestForFibonacci {

    /*
     这个版本的解法就是暴力穷举 可以看出用时很多
     n =45 则最终结果是：1836311903,用时：5732
     */
    public static long soulution1(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        return soulution1(n - 1) + soulution1(n - 2);
    }

    // 初始化一个记录簿传递进来 用于记录
    // 效果很明显 最终结果是：1836311903,用时：1
    // 按照拆解出来的数据结构可以
    public static long soulution2(ConcurrentHashMap<Integer, Long> tmap, int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        if (tmap.get(n) != 0) {
            return tmap.get(n);
        } else {
            tmap.put(n, soulution2(tmap, n - 1) + soulution2(tmap, n - 2));
        }
        return tmap.get(n);
    }

    // 知道了自顶向下的结题思路，那么自底向上的结题思路也就可以实现了
    // 因为知道了记录薄的记录顺序，那么就可以初始化记录簿，并按照算法右边的规则进行计算
    public static long solution3(int n){
        Vector<Long> v = new Vector<>(n);
        v.add(0,new Long(1));
        v.add(1,new Long(1));
        for (int i = 2;i<n;i++){
            v.add(i,v.get(i-1) + v.get(i -2 ));
        }
        return v.get(n -1);
    }

    // 再次优化解法3的空间复杂度 ，将dp表 改为方法内部的局部变量
    // 最终结果是：1836311903,用时：0
    public static long solution4(int n ){

        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }


    public static void main(String[] args) {
        /*int n = 46;
        Date now = new Date();
        long nowtime = now.getTime();

        ConcurrentHashMap<Integer, Long> temp = new ConcurrentHashMap(n);
        //IntStream.range(1,n).forEach();
        for (int i =1;i<=n;i++) {
            temp.put(i,new Long(0));
        }
        long s = soulution2(temp,n);
        now = new Date();
        System.out.println("最终结果是：" + s + ",用时：" + (now.getTime() - nowtime));*/

        /*ConcurrentHashMap<Integer, Long> tmp = new ConcurrentHashMap(1);
        Long tt = new Long(0);
        tmp.put(1, tt);
        tt = new Random(123).nextLong();

        System.out.println(tmp.get(1));*/

        int n = 46;
        Date now = new Date();
        long nowtime = now.getTime();

        long s = solution4(n);
        now = new Date();
        System.out.println("最终结果是：" + s + ",用时：" + (now.getTime() - nowtime));

    }
}
