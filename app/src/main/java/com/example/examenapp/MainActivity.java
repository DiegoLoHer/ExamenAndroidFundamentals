package com.example.examenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button1;
    String texto="Mexico";
    TextView text;
    ImageView ima;
    int q=0;
    SharedPreferences mPreferences;
    final String LABEL_KEY = "labelKey";
    final String FLAG_KEY = "flagKey";
    int imag = R.drawable.ic_mexico;
    String sharePreFile = "vals";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btnContinuar);
        button1=findViewById(R.id.btnTexto);
        text=findViewById(R.id.lblPais);
        text.setText(texto);

        mPreferences = getSharedPreferences(sharePreFile,MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q=10;
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        if (q>0) {
            texto = mPreferences.getString(LABEL_KEY, texto);
            text.setText(texto);
            imag = mPreferences.getInt(FLAG_KEY, imag);
            ima.setImageResource(imag);
        }

    }
}