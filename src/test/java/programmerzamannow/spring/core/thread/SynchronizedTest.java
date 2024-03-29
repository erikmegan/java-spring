package programmerzamannow.spring.core.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SynchronizedTest {
    @Test
    void synchronizedCounterWithThread() throws InterruptedException {
        var counter = new SyncrhonizedCounter();
        Runnable runnable = () ->{
            for (int i = 0 ; i<1000000 ; i++){
                counter.increment();
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        Assertions.assertEquals(counter.getValue(),3000000);
        System.out.println(counter.getValue());
    }
}
