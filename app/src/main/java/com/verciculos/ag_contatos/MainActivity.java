package com.verciculos.ag_contatos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button Btn_Cadastrar, Btn_listar;
    EditText et_nome, et_telefone, et_email, et_endereco, et_dataNasc;

    SQLiteDatabase db=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Btn_Cadastrar=(Button) findViewById(R.id.Btn_Cadastrar);
        Btn_listar=(Button) findViewById(R.id.Btn_listar);
        et_nome=(EditText) findViewById(R.id.et_nome_consulta);
        et_telefone=(EditText) findViewById(R.id.et_telefone_consulta);
        et_email=(EditText) findViewById(R.id.et_email_consulta);
        et_endereco=(EditText) findViewById(R.id.et_endereco_consulta);
        et_dataNasc=(EditText) findViewById(R.id.et_dataNasc_consulta);

        AbrirBanco();
        AbrirOuCriarTabela();
        FecharDB();

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

    public void AbrirOuCriarTabela(){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY, Nome TEXT, Telefone TEXT, email TEXT, endereco TEXT, dataNasc TEXT);");
        }catch (Exception ex) {
            msg("Erro ao abrir tabela");
        }
    }


   public void FecharDB(){
        db.close();
    }

    public void InserirRegistros(View v){
        String st_nome, st_telefone;
        st_nome=et_nome.getText().toString();
        st_telefone=et_telefone.getText().toString();
        if(st_nome=="" || st_telefone==""){
            msg("Campos não podem esta Vazios");
            return;
        }
        AbrirBanco();
        try {
            db.execSQL("INSERT INTO contatos (nome, telefone) VALUES('"+st_nome+"', '"+st_telefone+"')");
        }catch (Exception ex){
            msg("erro inserir reg");
        }finally {
            msg("Reg inserir ");
        }
        FecharDB();
        et_nome.setText(null);
        et_telefone.setText(null);
    }


    public void abrir_Cadastro(View v){
        Intent cadsatrar=new Intent(this, Cadastro.class);
        startActivity(cadsatrar);
    }

    public void abrir_Actvity2(View v){
        Intent listar=new Intent(this, Activity2.class);
        startActivity(listar);
    }

}