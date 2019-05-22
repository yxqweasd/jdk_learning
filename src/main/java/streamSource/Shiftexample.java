package streamSource;

/**
 * Created by huangweinan on 2019/5/7.
 */
public class Shiftexample {

    public static void main(String[] args) {
        System.out.println(-4 >> 1);
        System.out.println(Integer.toBinaryString(-4 >> 1));
        // prints "1111111111111111"

        System.out.println(-4 >> 2);
        System.out.println(Integer.toBinaryString(-4 >> 2));
    }
}
