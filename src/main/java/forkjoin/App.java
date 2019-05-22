package forkjoin;

import java.util.concurrent.*;

/**
 * Created by huangweinan on 2019/5/7.
 */
public class App {

    ExecutorService executor = null;
    ArchiveSearcher searcher = null;

    void showSearch(final String target)
            throws InterruptedException {
        Future<String> future
                = executor.submit(new Callable<String>() {
            public String call() {
                return searcher.search(target);
            }
        });

        /**
         * repacable function
         */
        FutureTask<String> future2 =
                new FutureTask<String>(new Callable<String>() {
                    public String call() {
                        return searcher.search(target);
                    }
                });
        executor.execute(future2);

        //displayOtherThings(); // do other things while searching

        try

        {
            System.out.println(future.get());
            //displayText(future.get()); // use future
        } catch (ExecutionException ex) {
            //cleanup();
            return;
        }
    }
}

interface ArchiveSearcher {
    String search(String target);
}
