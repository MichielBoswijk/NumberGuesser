// reference package
package com.michielbowijk.numberguesser;

// necessary imports
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

// class for the second screen of the app
public class SecondActivity extends Activity{

    // private variables used in the class
    private EditText inputField;
    private TextView finalMessage;
    private TextView informationDisplay;
    private int randomInt;
    private final int MIN = 1;
    private final int MAX = 1000;

    // method called when screen is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // call constructor of superclass (Activity)
        super.onCreate(savedInstanceState);
        // link with layout file
        setContentView(R.layout.second_layout);

        // generate pseudo-random integer in range(max, min)
        Random rand = new Random();
        randomInt = rand.nextInt((MAX - MIN) + 1) + MIN;

        // create objects of accessed widgets
        inputField = (EditText) findViewById(R.id.guess_value);
        finalMessage = (TextView) findViewById(R.id.final_message_id);
        informationDisplay = (TextView) findViewById(R.id.infoDisplay);
    }

    // method for processing the user's guess
    public void userGuess(View view) {

        // retrieve user's input
        String inputString  = String.valueOf(inputField.getText());

        // if input somehow contains anything else than numbers, catch exception
        try {
            // convert input String to integer
            int inputInt = Integer.parseInt(inputString);

            // show hints in textView object according to user's guess
            if (inputInt < MIN || inputInt > MAX) {
                informationDisplay.setText("Number not in range, try again.");
            } else if (randomInt == inputInt) {
                informationDisplay.setText("Great!");
                finalMessage.setText("Congratulations, you guessed correctly! \n\n Press the \'back\' button on your phone to try again. ");
            } else if (randomInt < inputInt) {
                informationDisplay.setText("My number is LOWER than that.");
            } else if (randomInt > inputInt) {
                informationDisplay.setText("My number is HIGHER than that.");
            }
        } catch (NumberFormatException e) {
            informationDisplay.setText("Please enter a valid number.");
        }
    }
}