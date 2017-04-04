package sample;

/**
 * Created by nicolaiemig on 02.04.17.
 */
public class BruteForce implements Runnable{
    Controller controller;
    String word;
    String alphabet;

    public BruteForce(Controller controller, String word, String alphabet) {
        this.controller = controller;
        this.word = word;
        this.alphabet = alphabet;
    }


    @Override
    public void run() {
        BruteForcer bruteForcer;
        switch (alphabet) {
            case "alpha":
                bruteForcer = BruteForcer.createAlphaBruteForcer();
                break;
            case "numeric":
                bruteForcer = BruteForcer.createNumericBruteForcer();
                break;
            case "alphanumeric":
                bruteForcer = BruteForcer.createAlphaNumericBruteForcer();
                break;
            default:
                bruteForcer = BruteForcer.createAlphaNumericBruteForcer();
                break;
        }


        String bfGenPW =null;

        Long counter = 0L;
        while (!word.equals(bfGenPW)) {
            bfGenPW = bruteForcer.computeNextCombination();
            counter++;
        }
        controller.calculations = counter;
        controller.stopTimer();
        controller.refreshDisplay();
        controller.refreshTextField(bfGenPW);
    }
}
