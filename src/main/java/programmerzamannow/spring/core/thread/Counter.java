package programmerzamannow.spring.core.thread;

public class Counter {

    private Long value = 0L;

    public void increment(){
        value++;
    }

    public Long getValue(){
        return value;
    }
}
