package com.example.examenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btnEs;
    Button btnIn;
    Button btnFr;
    ImageView ima;
    TextView text;
    SharedPreferences mPreferences;
    String sharePreFile = "vals";
    int imag = R.drawable.ic_mexico;
    String texto="Mexico";
    final String LABEL_KEY = "labelKey";
    final String FLAG_KEY = "flagKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnEs=findViewById(R.id.btnEspanol);
        btnIn=findViewById(R.id.btnIngles);
        btnFr=findViewById(R.id.btnFrances);
        ima=findViewById(R.id.image);
        text=findViewById(R.id.lblPais);
        text.setText(texto);
        mPreferences = getSharedPreferences(sharePreFile,MODE_PRIVATE);

        btnEs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.
                ima.setImageResource(R.drawable.ic_mexico);
                text.setText(R.string.mexico);
                texto=text.getText().toString();
                imag=R.drawable.ic_mexico;
            }
        });
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ima.setImageResource(R.drawable.ic_united_kingdom);
                text.setText(R.string.ingles);
                texto=text.getText().toString();
                imag=R.drawable.ic_united_kingdom;
            }
        });
        btnFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imag=R.drawable.ic_france;
                ima.setImageResource(imag);
                text.setText(R.string.frances);
                texto=text.getText().toString();

            }
        });

        //restore values

        texto=mPreferences.getString(LABEL_KEY,texto);
        text.setText(texto);
        imag=mPreferences.getInt(FLAG_KEY,imag);
        ima.setImageResource(imag);

    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor prefEdit = mPreferences.edit();
        prefEdit.putString(LABEL_KEY,texto);
        prefEdit.putInt(FLAG_KEY,imag);
        prefEdit.apply();
    }

}