package com.example.examenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenapp.datos.Abstracta;
import com.example.examenapp.datos.Imagen;

public class MainActivity4 extends AppCompatActivity {

    private EditText mReplay;
    private Button button;
    private TextView mMessage;
    public static final String EXTRA_REPLAY = "com.example.startactivityforresult.MainActivity2";
    private final String LOG_TAG = "ELOGES";

    private Imagen[] imagenes= {
            new Imagen(R.drawable.ic_mexico),
            new Imagen(R.drawable.ic_france),
            new Imagen(R.drawable.ic_united_kingdom),
            new Imagen(R.mipmap.ic_launcher)
    };

    private Abstracta[] imagenes2={
            new Abstracta(){
                @Override
                public int getImageResourse() {
                    return R.drawable.ic_mexico;
                }
            },new Abstracta(){
        @Override
        public int getImageResourse() {
            return R.drawable.ic_france;
        }
    },new Abstracta(){
        @Override
        public int getImageResourse() {
            return R.drawable.ic_united_kingdom;
        }
    }

    };
    //private Imagen[] imagenes1;
    ImageView imageView;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mReplay = findViewById(R.id.txtNombre);
        button = findViewById(R.id.btnSig);
        mMessage = findViewById(R.id.txtTexto);
        Intent intent = getIntent();
        String nombre = null;
        if(intent != null){
            nombre = intent.getStringExtra(MainActivity3.EXTRA);
            mMessage = findViewById(R.id.txtTexto);
            if(nombre != null){
                mMessage.setText("Hola "+nombre);
            }
        }

        imageView=findViewById(R.id.imageView2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity4.this, "Siguiente Imagen", Toast.LENGTH_LONG).show();
                imageView.setImageResource(imagenes2[i++].getImageResourse());

                if (i==3)
                    i=0;
            }
        });

    }
    public void returnReplay(View view){
        String reply = mReplay.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLAY,reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}