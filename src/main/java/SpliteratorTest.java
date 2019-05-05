import java.util.*;
import java.util.function.DoubleConsumer;

public class SpliteratorTest {

    public static void main(String[] args) {

    }


    public Spliterator myTrySplit(List list) {
        int batchSize = 1 << 10;

        int est = list.size();

        ArrayList arrayList = new ArrayList(batchSize);


        int j = 0;

        Iterator i = list.iterator();
        if (est > 1 && i.hasNext()) {
            while (i.hasNext() && j < batchSize) {
                arrayList.add(list.iterator().next());
                j++;
            }
        }

        return null;



    }
}
