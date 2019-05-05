package stream;

import java.util.Arrays;
import java.util.List;

public class JavaStreams7 {


    public static void main(String[] args) {

        // 7. Stream from List, filter and print

        List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "amands", "Hans", "Shivika");

        people.stream().map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }
}
