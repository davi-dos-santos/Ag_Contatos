package com.verciculos.ag_contatos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Cadastro extends AppCompatActivity {

    EditText et_nome, et_telefone, et_email, et_endereco, et_dataNasc;
    SQLiteDatabase db=null;
    Cursor cursor;

    ImageButton Btn_Voltar_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro);

        Btn_Voltar_img=(ImageButton) findViewById(R.id.Btn_Voltar_img);

        et_nome =(EditText) findViewById(R.id.et_nome_consulta);
        et_telefone =(EditText) findViewById(R.id.et_telefone_consulta);
        et_email =(EditText) findViewById(R.id.et_email_consulta);
        et_endereco =(EditText) findViewById(R.id.et_endereco_consulta);
        et_dataNasc =(EditText) findViewById(R.id.et_dataNasc_consulta);

        buscarDados();

    }

    public void Voltar_actvity_main(View v) {
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }


    public void msg(String txt){
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setMessage(txt);
        adb.setNeutralButton("OK", null);
        adb.show();
    }

    public void AbrirBanco(){
        try {
            db=openOrCreateDatabase("BancoAgenda", MODE_PRIVATE, null);
        }catch (Exception ex){
            msg("Erro ao abrir ou criar BD");
        }
    }

    public void fecharDB(){
        db.close();
    }

    public void buscarDados(){
        AbrirBanco();
        cursor=db.query( "contatos",
                new String[]{"nome", "telefone", "email", "endereco", "dataNsc"},
                null,null,null,null,null,null
        );
        if(cursor.getCount()!=0){
            cursor.moveToFirst();
            //mostrarDados();
        }else{
            msg("Nenhum registro encontrado");
        }
    }
}