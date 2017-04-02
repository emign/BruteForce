package sample;

/**
 * Created by nicolaiemig on 02.04.17.
 */
public class BruteForce implements Runnable{
    Controller controller;
    String word;


    public BruteForce(Controller controller, String word){
        this.controller = controller;
        this.word = word;
    }


    @Override
    public void run() {
        BruteForcer bruteForcer = BruteForcer.createAlphaBruteForcer();
        String bfGenPW =null;
        while (!word.equals(bfGenPW)) {
            bfGenPW = bruteForcer.computeNextCombination();

            controller.calculations++;

        }
        System.out.println(String.format("Decrypted string: %s", bfGenPW));
        controller.stopTimer();
        controller.refreshDisplay();
    }
}
