package com.verciculos.ag_contatos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.database.Cursor;
import android.widget.*;

import com.verciculos.ag_contatos.DAO.DAO;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    ListView ListView;
    Button Btn_listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    DAO dao2 = new DAO(getApplicationContext());
                    List<Pessoa> pessoas = dao2.buscaPessoa();
                    List<String> nomes = new ArrayList<String>();

                    for (Pessoa nomeBuscado : pessoas){
                        nomes.add(nomeBuscado.getEt_nome_consulta());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, nomes);
                    ListView.setAdapter(adapter);
            }
        });

    }

/*
    ImageButton Btn_Voltar_img;
    EditText et_nome, et_telefone, et_email, et_endereco, et_dataNasc;
    SQLiteDatabase db=null;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_2);

        et_nome =(EditText) findViewById(R.id.et_nome_consulta);
        et_telefone =(EditText) findViewById(R.id.et_telefone_consulta);
        et_email =(EditText) findViewById(R.id.et_email_consulta);
        et_endereco =(EditText) findViewById(R.id.et_endereco_consulta);
        et_dataNasc =(EditText) findViewById(R.id.et_dataNasc_consulta);

       // buscarDados();

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
                new String[]{"nome", "telefone"},
                null,
                null,
                null,
                null,
                null,
                null
        );
        if(cursor.getCount()!=0){
            cursor.moveToFirst();
            MostrarDados();
        }else{
            msg("Nenhum registro encontrado");
        }
    }

    public void proximoRegistro(View v){
        try{
            cursor.moveToFirst();
            MostrarDados();
        }catch (Exception ex){
            if(cursor.isAfterLast()){
                msg("Não tem mais regsitro");
            }else{
                msg("Erro ao navegar");
            }
        }
    }

    public void anteriorRegistro(View v){
        try{
            cursor.moveToPrevious();
            MostrarDados();
        }catch (Exception ex){
            if(cursor.isBeforeFirst()){
                msg("Não tem mais regsitro");
            }else{
                msg("Erro ao navegar");
            }
        }
    }

    @SuppressLint("Range")
    public void MostrarDados(){
        et_nome.setText(cursor.getString(cursor.getColumnIndex("nome")));
        et_telefone.setText(cursor.getString(cursor.getColumnIndex("telefone")));
    }


*/

}