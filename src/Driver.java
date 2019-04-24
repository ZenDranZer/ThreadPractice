public class Driver {

    public static void main(String[] args) {
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
    }
}
