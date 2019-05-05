package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams4 {


    public static void main(String[] args) {

        // 4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }
}
