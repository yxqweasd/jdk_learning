package stream;

import java.util.stream.IntStream;

public class JavaStreams2 {


    public static void main(String[] args) {

        // 2. Integer Stream with skip
        IntStream.range(1, 10)
                .skip(5)
                .forEach(System.out::print);

        System.out.println();
    }
}
