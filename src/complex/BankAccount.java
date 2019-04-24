package complex;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private static Lock lock = new ReentrantLock();

    private static Condition newDeposite = lock.newCondition();

    private int balance = 0 ;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount){
        lock.lock();
        try{
            while (balance < amount)
                newDeposite.await();
            balance -= amount;
            System.out.println("Amount withdrawn Balance : " + balance);
        }catch (InterruptedException e){
            System.out.println("exception");
        }finally {
            lock.unlock();
        }
    }

    public void deposite(int amount){

        lock.lock();

        try {
            balance+=amount;
            System.out.println("Deposited amount Balance :" + balance);
            newDeposite.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
