import advance.Counter;
import basic.PrintCharacter;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

    public static void main(String[] args) {

        System.out.println("----------------------------- Basic Output -----------------------------");

        Thread printOne = new Thread(new PrintCharacter('1'));
        Thread printTwo = new Thread(new PrintCharacter('2'));
        Thread printA = new Thread(new PrintCharacter('A'));
        Thread printB = new Thread(new PrintCharacter('B'));
        printB.setPriority(10);
        printOne.setPriority(4);
        printTwo.setPriority(7);
        printA.setPriority(1);
        printA.start();
        printB.start();
        printOne.start();
        printTwo.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("\nexception");
        }

        System.out.println("\n----------------------------- Intermediate Output -----------------------------");
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new PrintCharacter('A'));
        service.execute(new PrintCharacter('2'));
        service.execute(new PrintCharacter('1'));
        service.execute(new PrintCharacter('B'));
        System.out.println(service.isShutdown());
        service.shutdown();
        System.out.println(service.isShutdown());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("\nexception");
        }

        System.out.println("\n----------------------------- Advance Output -----------------------------");

        Counter counter = new Counter();

        System.out.println("\n----------------------------- Complex Output -----------------------------");




    }
}
