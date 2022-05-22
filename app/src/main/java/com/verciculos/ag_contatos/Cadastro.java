package com.verciculos.ag_contatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class Cadastro extends AppCompatActivity {

    EditText et_dataNasc;
    DatePickerDialog.OnDateSetListener setListener;

    ImageButton Btn_Voltar_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        et_dataNasc=findViewById(R.id.et_dataNasc);

        Calendar calendar = Calendar.getInstance();
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        final int year = calendar.get(Calendar.YEAR);

        Btn_Voltar_img=(ImageButton) findViewById(R.id.Btn_Voltar_img);
    }

    public void Voltar_actvity_main(View v) {
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }
}