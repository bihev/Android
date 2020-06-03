package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Height, Weight;
    private TextView Result, Result2;
    private Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Height = (EditText)findViewById(R.id.etHeight);
        Weight = (EditText)findViewById(R.id.etweight);
        Result = (TextView)findViewById(R.id.tvResult);
        Result2 = (TextView)findViewById(R.id.tvResult2);
        Calculate = (Button)findViewById(R.id.button);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi();
            }
        });

    }

    private void bmi(){
        float a, b, c;

        a = Float.parseFloat(Height.getText().toString())/100;
        b = Float.parseFloat(Weight.getText().toString());
        c = b/(a * a);
        Result.setText("BMI: " + c);

        if( c <= 18.5 ){
            Result2.setText("UnderWeight");
        }
        else if( (c >= 18.5) && (c < 24.9) ){
            Result2.setText("Healthy/Normal Weight");
        }
        else if ( c > 25 ){
            Result2.setText("OverWeight");
        }
    }
}
