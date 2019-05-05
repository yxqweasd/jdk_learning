package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams14 {


    public static void main(String[] args) throws IOException {

        // 14. Reduction - summary statistics

        IntSummaryStatistics summary = IntStream.of(7, 2, 1988, 73, 4, 10).summaryStatistics();
        System.out.println(summary);
    }
}
