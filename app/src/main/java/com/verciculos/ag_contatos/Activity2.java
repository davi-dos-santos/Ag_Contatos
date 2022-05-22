package com.verciculos.ag_contatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    Button Btn_Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Btn_Voltar=(Button) findViewById(R.id.Btn_Voltar);
    }

    public void Voltar_actvity_main(View v) {
        Intent voltar = new Intent(this, activity2.class);
        startActivity(voltar);
    }
}