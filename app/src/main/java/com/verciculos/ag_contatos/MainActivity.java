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

import com.verciculos.ag_contatos.DAO.DAO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListView;
    Button Btn_Cadastrar, Btn_listar;
    EditText et_nome, et_telefone, et_email, et_endereco, et_dataNasc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_Cadastrar = findViewById(R.id.Btn_Cadastrar);
        Btn_listar = findViewById(R.id.Btn_listar);
        et_nome = findViewById(R.id.et_nome_consulta);
        et_telefone = findViewById(R.id.et_telefone_consulta);
        et_email = findViewById(R.id.et_email_consulta);
        et_endereco = findViewById(R.id.et_endereco_consulta);
        et_dataNasc = findViewById(R.id.et_dataNasc_consulta);

        Btn_Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(et_nome.getText().toString().equals("") ||
                        et_telefone.getText().toString().equals("") ||
                        et_email.getText().toString().equals("") ||
                        et_endereco.getText().toString().equals("") ||
                        et_dataNasc.getText().toString().equals(""))) {

                    DAO dao = new DAO(getApplicationContext());
                    Pessoa pessoa = new Pessoa();
                    pessoa.setEt_nome_consulta(et_nome.getText().toString());
                    pessoa.setEt_telefone_consulta(Integer.valueOf(et_telefone.getText().toString()));
                    pessoa.setEt_email_consulta(et_email.getText().toString());
                    pessoa.setEt_endereco_consulta(et_endereco.getText().toString());
                    pessoa.setEt_dataNasc_consulta(Integer.valueOf(et_dataNasc.getText().toString()));
                    dao.InserePessoa(pessoa);
                    dao.close();

                    et_nome.setText("");
                    et_nome.requestFocus();
                    et_telefone.setText("");
                    et_email.setText("");
                    et_endereco.setText("");
                    et_dataNasc.setText("");

                    DAO dao2 = new DAO(getApplicationContext());
                    List<Pessoa> pessoas = dao2.buscaPessoa();
                    List<String> nomes = new ArrayList<String>();

                    for (Pessoa nomeBuscado : pessoas){
                        nomes.add(nomeBuscado.getEt_nome_consulta());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, nomes);
                    ListView.setAdapter(adapter);

                } else {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    /*
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
*/
}