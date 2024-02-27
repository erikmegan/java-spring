package programmerzamannow.spring.core.thread;

public class SyncrhonizedCounter {
    private Long value = 0L;

    public void increment(){
        synchronized (this){
            value++;
        }
    }

    public Long getValue(){
        return value;
    }
}
