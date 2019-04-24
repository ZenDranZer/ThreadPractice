package advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter {
    private static CounterHolder counterHolder;
    public Counter() {
        Counter.counterHolder = new CounterHolder();

        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for (int i = 0 ; i < 10 ; i ++){
            executorService.execute(new Increment());
            System.out.println(counterHolder.getCounter());
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){
        }
        System.out.println("Balance : " + counterHolder.getCounter());
    }

    private static class CounterHolder {

        private final static Object lock = new Object();
        private int counter;

        public CounterHolder() {
            counter = 0;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            try {
                    counter = this.counter++;
                    Thread.sleep(500);
                    this.counter = counter;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Increment implements Runnable{
        @Override
        public void run() {
            counterHolder.setCounter(1);
        }
    }
}
