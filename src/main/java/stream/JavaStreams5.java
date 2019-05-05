package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class JavaStreams5 {


    public static void main(String[] args) {

        // 5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amands", "Hans", "Shivika"};

        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted().forEach(System.out::println);
    }
}
