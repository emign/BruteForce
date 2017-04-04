package sample;

/**
 * Created by nicolaiemig on 02.04.17.
 */
public class BruteForce implements Runnable{
    Controller controller;
    String word;
    String alphabet;
    Boolean traced;

    public BruteForce(Controller controller, String word, String alphabet, Boolean traced) {
        this.controller = controller;
        this.word = word;
        this.alphabet = alphabet;
        this.traced = traced;
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
        StringBuilder trace = new StringBuilder();


        Long counter = 0L;
        while (!word.equals(bfGenPW)) {
            bfGenPW = bruteForcer.computeNextCombination();
            counter++;
            if (traced){
                trace.append(counter).append(":").append(bfGenPW).append(System.getProperty("line.separator"));
            }
        }
        if (traced){
            controller.trace.append(trace);
        }

        controller.calculations = counter;
        controller.stopTimer();
        controller.refreshDisplay();
        controller.refreshTextField(bfGenPW);
    }
}
