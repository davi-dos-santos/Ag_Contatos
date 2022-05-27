package com.verciculos.ag_contatos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    Button Btn_Cadastrar, Btn_listar;
    EditText et_nome, et_telefone, et_email, et_endereco, et_dataNasc;

    SQLiteDatabase db=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Btn_Cadastrar = (Button) findViewById(R.id.Btn_Cadastrar);
        Btn_listar = (Button) findViewById(R.id.Btn_listar);
        et_nome =(EditText) findViewById(R.id.et_nome);
        et_telefone =(EditText) findViewById(R.id.et_telefone);
        et_email =(EditText) findViewById(R.id.et_email);
        et_endereco =(EditText) findViewById(R.id.et_endereco);
        et_dataNasc =(EditText) findViewById(R.id.et_dataNasc);

        AbrirBanco();
        AbrirOuCriarTabela();
        fecharDB();

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

    public void AbrirOuCriarTabela(){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY, nome TEXT, telefone TEXT, email TEXT, endereco TEXT, dataNsc TEXT)");
        }catch (Exception ex){
            msg("Erro ao abrir ou criar Tabela");
        }
    }


    public void inserirRegistro(View v){
        String st_nome, st_telefone, st_email, st_endereco, st_dataNsc;
        st_nome=et_nome.getText().toString();
        st_telefone=et_telefone.getText().toString();
        st_email=et_email.getText().toString();
        st_endereco=et_endereco.getText().toString();
        st_dataNsc=et_dataNasc.getText().toString();
        if(st_nome=="" || st_telefone=="" || st_email=="" || st_endereco=="" || st_dataNsc==""){
            msg("Campos não podem esta Vazios");
            return;
        }
        AbrirBanco();
        try{
            db.execSQL("INSERT INTO contatos (nome, telefone, email, endereco, dataNsc) VALUES ('"+st_nome+"', '"+st_telefone+"', '"+st_email+"', '"+st_endereco+"', '"+st_dataNsc+"')");
        }catch (Exception ex){
            msg("Erro ao salvar registro");
        }finally {
            msg("Registro inseridos");
        }
        fecharDB();
        et_nome.setText(null);
        et_telefone.setText(null);
        et_email.setText(null);
        et_endereco.setText(null);
        et_dataNasc.setText(null);
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