package stream;

import java.util.stream.IntStream;

public class JavaStreams1 {


    public static void main(String[] args) {


        // 1. Integer Stream
        IntStream.range(1, 10)
                .forEach(System.out::print);

        System.out.println();
    }
}
