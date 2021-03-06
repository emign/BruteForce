package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;

public class Controller implements Runnable{
    public Long calculations = new Long(0);
    public long startTime = System.nanoTime();
    public long stopTime = System.nanoTime();
    public Long runTime = 0L;
    public double calcPerSecond = 0.0;
    public StringBuilder trace = new StringBuilder();
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private Label labelCalcs;
    @FXML
    private Label labelCalcsPerSecond;
    @FXML
    private Label labelDauer;
    @FXML
    private Button buttonKnacken;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private RadioButton checkBoxAlpha;
    @FXML
    private RadioButton checkBoxNumeric;
    @FXML
    private RadioButton checkBoxAlphaNumeric;
    @FXML
    private TextArea textFieldResult;
    @FXML
    private TextArea textAreaTrace;
    @FXML
    private CheckBox checkBoxTrace;
    @FXML
    private Label labelLength;
    private LinkedList<RadioButton> checkBoxes = new LinkedList<RadioButton>();

    @FXML
    public void initialize() {
        checkBoxes.add(checkBoxAlpha);
        checkBoxes.add(checkBoxNumeric);
        checkBoxes.add(checkBoxAlphaNumeric);
    }

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

        BruteForce b = new BruteForce(this, word, checkedCheckBox(), checkBoxTrace.isSelected());
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

    public void refreshTextField(String text) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textFieldResult.setText(text + System.getProperty("line.separator"));
                if (!trace.toString().isEmpty()){
                    textAreaTrace.setText(trace.toString());
                }
            }
        });
    }

    public void refreshLabelLength() {
        labelLength.setText(String.valueOf(textFieldPassword.getText().length()));
    }

    private void resetDisplay(){
        calculations = 0L;
        startTime = 0L;
        stopTime = 0L;
        runTime = 0L;
        trace.setLength(0);
    }

    private String checkedCheckBox() {
        String checkedBox = "";
        for (RadioButton checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                checkedBox = checkBox.getId();
            }
        }
        return checkedBox;
    }


    @Override
    public void run() {
        runTime = stopTime-startTime;
        double seconds = (double)runTime / 1000000000.0;
        //labelDauer.setText(String.valueOf(seconds));
        labelDauer.setText(new DecimalFormat("#.##").format(seconds));
        labelCalcs.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format(calculations));
        progressIndicator.setVisible(false);
        buttonKnacken.setDisable(false);
        calcPerSecond = calculations / seconds;
        labelCalcsPerSecond.setText(NumberFormat.getNumberInstance(Locale.GERMANY).format((long)calcPerSecond));


    }
}
