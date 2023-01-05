package day1112;

public class TestForFrog {


    private static long[] fiboshuzu;

    public static long fibo(int n){

        fiboshuzu = new long[n];
        if(n <=2){
            return n;
        }

        fiboshuzu[0] = 1;
        fiboshuzu[1] = 2;

        long sum = 0;
        for (int i = 3;i<=n;i++){
            sum = fiboshuzu[i-2] + fiboshuzu[i-3];
            fiboshuzu[i-1] = sum;
        }
        return sum;
    }
    public static void main(String[] args) {

        // 问题 比如斐波那契数列 或者说一只青蛙一次可以上一个台阶 或者 上两个台阶
        //      那么如果有n个台阶，可以有多少种上台阶的方法
        //1 描述问题定义 即f(n) 是n级台阶 有多少种上法的值
        //2 描述问题的算法:问题正面思考可能比较费劲 换另外一种思考方式的话
        //  就是倒叙思考  比如 f(n) 应该是 f(n-1) + f(n-2)，因为有两种上去的方法，在距离n只有一阶或者二阶
        //  的时候 都只有一种上去的方式 则通过归纳法 可以知道 f(n) = f(n-1) + f(n-2) 这个是算法的主体
        //3 描述问题的初始值 一般的 如果n很小的话，我们其实是可以直接计算出其值的 比如本题 我们就知道
        //  f(1) = 1  f(2) = 2 可以一次上一阶上两次 一次上两阶上一次 那么算出f(n) 只是 前面数据的和而已 用数组记录下来就好了
        long i = TestForFrog.fibo(92);
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

    }
}
