package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etZaehler;
    EditText etNenner;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etZaehler = findViewById(R.id.zaehler);
        etNenner = findViewById(R.id.nenner);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        int nenner = Integer.parseInt(etNenner.getText().toString());
        int zaehler = Integer.parseInt(etZaehler.getText().toString());
        
        int z1, z2, r;
        
        if (zaehler < nenner) {
            z2 = zaehler;
            z1 = nenner;
        } else {
            z1 = zaehler;
            z2 = nenner;
        }
        
        r = z1 % z2;
        
        while (r != 0) {
            z1 = z2;
            z2 = r;
            r = z1 % z2;
            
        }
        
        etZaehler.setText(Integer.toString(zaehler / z2));
        etNenner.setText(Integer.toString(nenner / z2));
    }
}