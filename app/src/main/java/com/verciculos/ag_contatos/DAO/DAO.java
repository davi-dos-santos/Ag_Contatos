package com.verciculos.ag_contatos.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.verciculos.ag_contatos.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class DAO extends SQLiteOpenHelper {
    public DAO(Context context){
        super(context, "banco", null, 1);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        String sql = "CREATE TABLE pessoa( Nome TEXT, Telefone Integer, email TEXT, endereco TEXT, dataNasc Integer);";
            db.execSQL(sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        String sql = "DROP TABLE IF EXISTS pessoa;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void InserePessoa(Pessoa pessoa){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put("nome", pessoa.getEt_nome_consulta());
        dados.put("telefone", pessoa.getEt_telefone_consulta());
        dados.put("email", pessoa.getEt_email_consulta());
        dados.put("endereco", pessoa.getEt_endereco_consulta());
        dados.put("dataNasc", pessoa.getEt_dataNasc_consulta());

        db.insert("pessoa", null, dados);

    }

    @SuppressLint("Range")
    public List<Pessoa> buscaPessoa(){

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM pessoa;";

        Cursor c = db.rawQuery(sql, null);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (c.moveToNext()){
            Pessoa pessoa = new Pessoa();
            pessoa.setEt_nome_consulta(c.getString(c.getColumnIndex("nome")));
            pessoa.setEt_telefone_consulta(Integer.valueOf(c.getColumnIndex("telefone")));
            pessoa.setEt_email_consulta(c.getString(c.getColumnIndex("nome")));
            pessoa.setEt_endereco_consulta(c.getString(c.getColumnIndex("nome")));
            pessoa.setEt_dataNasc_consulta(Integer.valueOf(c.getColumnIndex("telefone")));

        }
        return pessoas;
    }
}
