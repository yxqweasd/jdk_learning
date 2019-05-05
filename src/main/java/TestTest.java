import java.util.Spliterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class TestTest {


    public static void main(String[] args) throws Exception{
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(1024);

        while (q.size() < 10) {
            q.put(q.size() + 1);
        }


        Spliterator<Integer> split = q.spliterator();
        split.forEachRemaining(System.out::println);
        System.out.println("----------------");
        split.forEachRemaining(System.out::println);
    }
}
