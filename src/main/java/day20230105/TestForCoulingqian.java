package day20230105;

public class TestForCoulingqian {

    public static int[] a = {1, 2, 5, 10, 20, 50, 100, 1000};

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

    public static void main(String[] args) {
        double amount = 112222122223333.1d;
        double aa = solution1(a, amount, a.length - 1);

        if (aa == -1) {
            System.out.println("不可能凑出这个金额");
        } else if (aa == 0) {
            System.out.println("可以凑出这个金额");
        }

        /*a = Arrays.copyOf(a, 0);
        System.out.println("1");*/
    }
}
