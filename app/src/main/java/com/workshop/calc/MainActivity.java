package com.workshop.calc;

import static com.workshop.calc.R.id.bod;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView bout;
    private EditText bod;
    private Button plus;
    private Button minus;
    private Button multi;
    private Button divide;
    private Button clear;
    private Button eq;

    private double initia = Double.NaN;
    private double fina;
    private static final char add='+';
    private static final char sub='-';
    private static final char mult='x';
    private static final char div='÷';
    private char use;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bout = findViewById(R.id.bout);
        bod = findViewById(R.id.bod);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multi = findViewById(R.id.multi);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        eq= findViewById(R.id.eq);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myme();
                use=add;
                bout.setText(initia+" + ");
                bod.setText(null);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myme();
                use=sub;
                bout.setText(initia+" - ");
                bod.setText(null);
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myme();
                use=mult;
                bout.setText(initia+" * ");
                bod.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myme();
                use=div;
                bout.setText(initia+" ÷ ");
                bod.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myme();
                bout.setText(null);
                bod.setText(null);
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myme();
                bout.setText(bout.getText().toString() + fina +" = " + initia);
                initia=Double.NaN;
                use='0';
            }
        });
    }
        public void myme() {
            if(!Double.isNaN(initia)) {
                fina = Double.parseDouble(bod.getText().toString());
                bod.setText(null);

                if (use == add)
                    initia = this.initia + fina;
                else if (use == sub)
                    initia = this.initia - fina;
                else if (use == mult)
                    initia = this.initia * fina;
                else if (use == div)
                    initia = this.initia / fina;
            }
            else{
                try {initia=Double.parseDouble(bod.getText().toString());}
                catch (Exception e) {}
            }
        }
}