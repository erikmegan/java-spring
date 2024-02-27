package programmerzamannow.spring.core.thread;

import org.junit.jupiter.api.Test;

public class DeadLockTest {

    @Test
    void testTransferFailed() throws InterruptedException {
        var balance1 = new Balance(1000000L);
        var balance2 = new Balance(1000000L);

        var thread1 = new Thread(() -> {
            try {
                Balance.transfer(balance1,balance2,500000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        var thread2 = new Thread(() -> {
            try {
                Balance.transfer(balance2,balance1,500000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("balance1 : " + balance1.getValue());
        System.out.println("balance2 : " + balance2.getValue());
    }
}
