package day20230105;

import java.util.Date;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给你 k 种⾯值的硬币，⾯值分别为 c1, c2 ... ck ，每种硬
 * 币的数量⽆限，再给⼀个总⾦额 amount ，问你最少需要⼏枚硬币凑出这个
 * ⾦额，如果不可能凑出，算法返回 -1
 * <p>
 * 分析可以的到dp(n)=
 * 0,n =0-1,n <0
 * min{dp(n - coin) + 1}coin in coins,n > 0
 */
public class TestForCoulingqian {

    //public static int[] a = {1, 2, 5, 10, 20, 50, 100, 1000};


    /**
     * 自己写的第一版方案，这个方案有些直接，过于专注题干中的最少min，而没有提炼出状态转移方程
     *
     * @param a
     * @param amount
     * @param l
     * @return
     */
    public static double solution1(int[] a, double amount, int l) {

        if (l == -1) {
            return -1;
        } else if (amount == 0) {
            return 0;
        } else if (a[l] <= amount) {
            amount = amount % a[l];
            amount = solution1(a, amount, l);
        } else if (a[l] > amount) {

            amount = solution1(a, amount, l - 1);
        }
        return amount;
    }

    static ConcurrentHashMap<Integer, Integer> temp = new ConcurrentHashMap<>(Integer.MAX_VALUE);

    public static int solution2(int[] coins, int amount) {
        if (temp.containsKey(amount)) {
            return temp.get(amount);
        }
        if (amount == 0) {
            // 这里如果进来的是0 应该结束了不在需要有硬币了
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int bitcoin = Integer.MAX_VALUE;
        for (int i : coins) {

            int result = solution2(coins, amount - i);
            if (result == -1) {
                if (!temp.containsKey(amount)) temp.put(amount, -1);
                continue;
            }
            bitcoin = Math.min(result + 1, bitcoin);
        }
        if (!temp.containsKey(amount)) temp.put(amount, bitcoin == Integer.MAX_VALUE ? -1 : bitcoin);
        return bitcoin == Integer.MAX_VALUE ? -1 : bitcoin;
    }

    public static int[] a = {1,50,1000};
    // 这个方法是自底向上的方法，好处是不需要那么多的内存栈了，当amount比较大，coins数组比较多的时候，不会栈溢出
    public static int solution3(int[] coins, int amount) {
        int l = amount + 1;
        ConcurrentHashMap<Integer, Integer> temp = new ConcurrentHashMap<>(l);
        for (int i = 0; i < l; i++) {
            temp.put(i, amount);
        }
        temp.put(0, 0);
        for (int i = 0; i < l; i++) {
            for (int coin : coins) {
                // 如果要记录路径的方式，也就是输出最值的取得结果，需要在作出决定时记录日志 同时可以考虑另外一个问题，如果要在
                // 多个可行解中（或者最优值有多个时，如何分辨出这多种解）
                if (i - coin < 0) {
                    continue;
                }
                int re = Math.min(temp.get(i), 1 + temp.get(i - coin));
                // 敲出来的代码一直不对，看了v.add的源码注释，解释为Vector指定位置添加数据会将原有的数据移开，也就是不会删除
                // 如果要更新的话，需要先删除后更新，使用map就没这事了。
                temp.put(i, re);
            }
        }

        return (temp.get(amount) == amount + 1) ? -1 : temp.get(amount);
    }

    public static void main(String[] args) {
        /*double amount = 112222122223333d;
        double aa = solution1(a, amount, a.length - 1);

        if (aa == -1) {
            System.out.println("不可能凑出这个金额");
        } else if (aa == 0) {
            System.out.println("可以凑出这个金额");
        }*/

        /*a = Arrays.copyOf(a, 0);
        System.out.println("1");*/

        long s = new Date().getTime();
        System.out.println();
        int amount = 299153;
        int re = solution3(a, amount);
        long e = new Date().getTime();
        if (re == -1) {
            System.out.println("不能够凑出这个金额,耗时"+ (e-s) );
        } else {
            System.out.println(String.format("最少用%s个硬币就可以凑出这个金额,耗时%s", re,(e-s)));
        }

    }
}
