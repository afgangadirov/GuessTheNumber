package com.example.sayitahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TexminActivity extends AppCompatActivity {

    private TextView textViewQalanHaqq, textViewKomek;
    private EditText editTextYazin;
    private Button buttonTexmin;

    private int ixtiyari;
    private int saygac = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texmin);

        textViewQalanHaqq = findViewById(R.id.textViewQalanHaqq);
        textViewKomek = findViewById(R.id.textViewKomek);
        editTextYazin = findViewById(R.id.editTextYazin);
        buttonTexmin = findViewById(R.id.buttonTexmin);


        Random r = new Random();
        ixtiyari = r.nextInt(101);

        Log.e("Ixtiyari eded", String.valueOf(ixtiyari));






        buttonTexmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saygac = saygac - 1;

                int texmin = Integer.parseInt(editTextYazin.getText().toString());

                if (texmin == ixtiyari){
                    Intent i = new Intent(TexminActivity.this,NeticeActivity.class);
                    i.putExtra("netice",true);
                    startActivity(i);
                    finish();
                    return;
                }
                if(texmin > ixtiyari){
                    textViewKomek.setText("Azalt");
                    textViewQalanHaqq.setText("Qalan Haqq : "+saygac);
                }
                if (texmin < ixtiyari){
                    textViewKomek.setText("Artir");
                    textViewQalanHaqq.setText("Qalan Haqq : "+saygac);
                }
                if (saygac == 0){
                    Intent i = new Intent(TexminActivity.this,NeticeActivity.class);
                    i.putExtra("netice",false);
                    startActivity(i);
                    finish();
                }
                editTextYazin.setText("");


            }
        });
    }
}