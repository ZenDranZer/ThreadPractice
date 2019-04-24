public class PrintCharacter implements Runnable {

    private char character;

    public PrintCharacter(char character) {
        this.character = character;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 100 ; i++)
            System.out.print(character + " ");
    }
}
