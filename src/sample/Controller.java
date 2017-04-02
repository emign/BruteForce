package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class Controller implements Runnable{
    @FXML private TextField textFieldPassword;
    @FXML private Label labelCalcPerSecond;
    @FXML private Label labelDauer;
    @FXML private Button buttonKnacken;
    @FXML private ProgressIndicator progressIndicator;

    public Long calculations = new Long(0);
    public long startTime = System.nanoTime();
    public long stopTime = System.nanoTime();
    public Long runTime = 0L;

   @FXML private void knackenKlicked(ActionEvent event){
       resetDisplay();
       if (textFieldPassword.getText() != null){
           startTimer();
           startBruteForceFor(textFieldPassword.getText());
           stopTimer();
       }

    }

    private void startBruteForceFor(String word){
        progressIndicator.setVisible(true);
        buttonKnacken.setDisable(true);

       BruteForce b = new BruteForce(this,word);
       Thread t1 = new Thread(b);
       t1.start();


    }

    private void startTimer(){
        startTime = System.nanoTime();
    }

    public void stopTimer(){
        stopTime = System.nanoTime();
    }

    public void refreshDisplay(){
        Platform.runLater(this);


    }

    private void resetDisplay(){
        calculations = 0L;
        startTime = 0L;
        stopTime = 0L;
        runTime = 0L;


    }
    @Override
    public void run() {
        runTime = stopTime-startTime;
        double seconds = (double)runTime / 1000000000.0;
        labelDauer.setText(String.valueOf(seconds));
        labelCalcPerSecond.setText(calculations.toString());
        progressIndicator.setVisible(false);
        buttonKnacken.setDisable(false);
    }
}
