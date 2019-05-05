package stream;

import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams13 {


    public static void main(String[] args) throws IOException {

        // 13. Reduction - sum

        double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (a, b) -> a + b);

        System.out.println("Total = " + total);
    }
}
