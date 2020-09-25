package com.example.examenapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private EditText mInput;
    private Button botonSend;
    private TextView mMessage;
    static final String EXTRA = "Main_Activity.EXTRA_NOMBRE";
    private final String LOG_TAG = "ELOGES";
    private String savedString;
    public static final int TEXT_REQUEST = 1;
    private final String EXTRA_SAVED = "valorIn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mInput = findViewById(R.id.txtNombre);
        botonSend = findViewById(R.id.btnSig);
        mMessage = findViewById(R.id.txtRes);



        botonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSecondActivity();
            }
        });
    }
    public void launchSecondActivity(){
        Log.d(LOG_TAG,"Buttonclicked");
        Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
        String message = mInput.getText().toString();
        intent.putExtra(EXTRA,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mMessage.setText(savedInstanceState.getString(EXTRA_SAVED));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity4.EXTRA_REPLAY);

                mMessage.setText(reply);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String savedS = mMessage.getText().toString();
        outState.putString(EXTRA_SAVED,savedS);
    }
}