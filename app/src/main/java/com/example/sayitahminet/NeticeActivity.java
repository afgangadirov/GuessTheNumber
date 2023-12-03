package com.example.sayitahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NeticeActivity extends AppCompatActivity {

    private ImageView imageViewNetice;
    private TextView textViewNetice;
    private Button buttonYeniden;

    private boolean netice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netice);

        imageViewNetice = findViewById(R.id.imageViewNetice);
        textViewNetice = findViewById(R.id.textViewNetice);
        buttonYeniden = findViewById(R.id.buttonYeniden);

        netice = getIntent().getBooleanExtra("netice",false);

        if (netice){
            textViewNetice.setText("UDDUNUZ");
            imageViewNetice.setImageResource(R.drawable.xosbext_shekil);
        }else{
            textViewNetice.setText("UDUZDUNUZ");
            imageViewNetice.setImageResource(R.drawable.bedbext_shekil);
        }

        buttonYeniden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NeticeActivity.this, TexminActivity.class));
                finish();
            }
        });
    }
}