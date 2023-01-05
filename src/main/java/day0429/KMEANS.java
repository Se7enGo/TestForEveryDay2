package day0429;

public class KMEANS {

    public static int[] M1 = {1, 2};
    public static int[] M2 = {1, 2};

    public static void main(String[] args) {

        double[] x = {1.66,1.34};
        double v = StandardDiviation(x);
        System.out.println(v);
    }

    /**
     * 均方差
     * @param x
     * @return
     */
    public static double StandardDiviation(double[] x) {
        int m = x.length;
        double sum = 0;
        for (int i = 0; i < m; i++) {//求和
            sum += x[i];
        }
        double dAve = sum / m;//求平均值
        double dVar = 0;
        for (int i = 0; i < m; i++) {//求方差
            dVar += (x[i] - dAve) * (x[i] - dAve);
        }
        //reture Math.sqrt(dVar/(m-1));
        return Math.sqrt(dVar / m);
    }
}
