package com.colombelli.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int flagSwitch = 0; // em 0 "enter amount in dollars" e em 1 "... real"

    public void switchCurrency(View view) // changes the hint in order to orient the user if the input should be given in dollar or real
    {
        TextView inputHint =  findViewById(R.id.valueInput);
        if (flagSwitch == 0) { // so, change to real value converter
            inputHint.setHint("Enter amount in real");
            flagSwitch = 1;
        }
        else //else, it is in real, so change to dollar converter
        {
            inputHint.setHint("Enter amount in dollar");
            flagSwitch = 0;
        }
    }

    public void convertCurrency(View view)
    {
        EditText inputValue = findViewById(R.id.valueInput); // the text box which receives, as input, the amount to convert
        EditText convertedValue = findViewById(R.id.convertedValue); // the text box which displays the converted value
        double valueToConvert = Double.valueOf(inputValue.getText().toString()); // the input value which corresponds to the dollar/real amount to convert
        DecimalFormat decimalFormat = new DecimalFormat("#.00"); // patter used to format double value to two decimal places

        if (flagSwitch == 0) // if the given value is in dollars, we convert to real
        {
            valueToConvert = 3.86 * valueToConvert; // new converted value
            Toast.makeText(this, "Dollars converted.", Toast.LENGTH_SHORT).show(); // displays a message informing that the conversion was succeed
        }

        else // if the given value is in real, we convert to dollar
        {
            valueToConvert = 0.26 * valueToConvert;
            Toast.makeText(this, "Reais converted.", Toast.LENGTH_SHORT).show();
        }

        convertedValue.setText(decimalFormat.format(valueToConvert)); // displays in the right text box the converted value
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
