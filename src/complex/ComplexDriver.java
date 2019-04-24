package complex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexDriver {

    private static BankAccount bankAccount = new BankAccount();

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new DepositeOperation());
        service.execute(new WithdrawOperation());
        service.shutdown();
    }

    private static class DepositeOperation implements Runnable{
        @Override
        public void run() {
            try{
                while (true){
                    bankAccount.deposite((int) (Math.random()*10) +1);
                    Thread.sleep(5000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static class WithdrawOperation implements Runnable{
        @Override
        public void run() {
                while (true)
                    bankAccount.withdraw((int) (Math.random()*10) +1);
        }
    }


}
