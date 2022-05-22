package com.verciculos.ag_contatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button Btn_Cadastrar, Btn_listar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_Cadastrar=(Button) findViewById(R.id.Btn_Cadastrar);
        Btn_listar=(Button) findViewById(R.id.Btn_listar);
    }

    public void abrir_Actvity2(View v){
        Intent listar=new Intent(this, activity2.class);
        startActivity(listar);
    }
}