/**
 * Created by zhaoshanshan on 16/4/22.
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> c
 * ....
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 52 -> AZ
 * <p>
 * 根据以上的表示,可以找出如下规律:
 * 26个字母A~Z该分别代表1-26的26个数字
 * 当数字大于26之后,就会用两个字母表示
 * 而该数字正好是第一个字母所代表的数字与26相乘+第二个字母所代表的数字
 */
public class Test1 {

    public static void main(String[] args) {
        //System.out.println(convertNum(703));
        System.out.println(convertToNum(702));
    }

    public static String convertNum(int num) {
        String[] alpha = {"A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};
        String result = "";
        if (num < 26) {
            return result = alpha[num - 1];
        }
        int i = num, j = 0;
        while (i > 26) {
            i = num / 26;
            j = num % 26;
            if (j > 0) {
                //有余数
                result = alpha[j - 1] + result;
            } else {
                //没有余数
                i = i - 1;
                result = 'Z' + result; //去0换Z
            }
            if (i > 26) {
                num = i;
            } else {
                result = alpha[i - 1] + result;
            }
        }
        return result;
    }

    public static String convertToNum(int num) {
        String[] alpha = {"A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};
        String result = "", j = "";
        while (num > 0) {
            int i = num % 26;
            if (i == 0) i = 26;
            j = alpha[i - 1];
            result = j + result;
            num = (num - 1) / 26;//有余数时并没有影响,没有余数时强制少进一位
        }
        return result;
    }
}
