package leetcode;

/**
 * Created by krosshuang on 2018/11/23.
 */
public class P50_Pow_x_n {

    public static void main(String[] args) {
        new P50_Pow_x_n().myPow(2, 10);
    }

    double[] mem = null;

    public double myPow(double x, int n) {
        mem = new double[n];
        return fastpow(x, n);
    }

    public double fastpow(double x, int n) {

        if (n == 0) {
            mem[n] = 1;
            return mem[n];
        } else if (n == 1) {
            mem[n] = x;
            return mem[n];
        } else {
            if (mem[n] != 0) {
                return mem[n];
            } else {
                if (n % 2 == 0) {
                    mem[n / 2] = fastpow(x, n / 2);
                    mem[n] = mem[n / 2] * mem[n / 2];
                    return mem[n];
                } else {
                    mem[n / 2] = fastpow(x, n / 2);
                    mem[n] = mem[n / 2] * mem[n / 2] * x;
                    return mem[n];
                }
            }
        }
    }
}
