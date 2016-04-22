/**
 * Created by zhaoshanshan on 16/4/22.
 * <p>
 * 爬n阶楼梯,可以一次爬1阶或者2阶
 * 请问有多少中爬法?
 */
public class Test2 {

    public static void main(String[] args) {
//        System.out.println(clibeStairs(8));
        System.out.println(climbStairsArray(8));
    }

    public static int clibeStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return clibeStairs(n - 1) + clibeStairs(n - 2);
    }

    public static int climbStairsOptimize(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static int climbStairsArray(int n) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i % 3] = arr[(i - 1) % 3] + arr[(i - 2) % 3];
        }
        return arr[n % 3];
    }
}
