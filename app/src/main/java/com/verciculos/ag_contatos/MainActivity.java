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

    SQLiteDatabase db=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_Cadastrar=(Button) findViewById(R.id.Btn_Cadastrar);
        Btn_listar=(Button) findViewById(R.id.Btn_listar);

        AbrirBanco();
        AbrirOuCriarTabela();
        fecharDB();

    }

    public void AbrirBanco(){
        try {
            db=openOrCreateDatabase("BancoAgenda", MODE_PRIVATE, null);
        }catch (Exception ex){
            msg("Erro ao abrir ou criar BD");
        }finally {
            msg("BD aberto");
        }
    }

    public void AbrirOuCriarTabela(){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY, nome TEXT, fone TEXT, email TEXT, endereço TEXT, dataNsc TEXT)");
        }catch (Exception ex){
            msg("Erro ao abrir ou criar Tabela");
        }
    }

    public void fecharDB(){
        db.close();
    }

    public void inserirRegistro(){
        AbrirBanco();
        String st_nome, st_fone, st_email, st_endereco, st_dataNsc;
        db.execSQL("");
        fecharDB();
    }

    public void abrir_Cadastro(View v){
        Intent cadsatrar=new Intent(this, Cadastro.class);
        startActivity(cadsatrar);
    }

    public void abrir_Actvity2(View v){
        Intent listar=new Intent(this, Activity2.class);
        startActivity(listar);
    }

    public void msg(String txt){
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setMessage(txt);
        adb.setNeutralButton("OK", null);
        adb.show();
    }
}