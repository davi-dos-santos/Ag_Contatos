package com.verciculos.ag_contatos;

import androidx.appcompat.app.AppCompatActivity;

public class Pessoa extends AppCompatActivity {

    String et_nome_consulta, et_email_consulta, et_endereco_consulta;
    Integer et_telefone_consulta, et_dataNasc_consulta;

    public String getEt_nome_consulta() {
        return et_nome_consulta;
    }

    public void setEt_nome_consulta(String et_nome_consulta) {
        this.et_nome_consulta = et_nome_consulta;
    }

    public String getEt_email_consulta() {
        return et_email_consulta;
    }

    public void setEt_email_consulta(String et_email_consulta) {
        this.et_email_consulta = et_email_consulta;
    }

    public String getEt_endereco_consulta() {
        return et_endereco_consulta;
    }

    public void setEt_endereco_consulta(String et_endereco_consulta) {
        this.et_endereco_consulta = et_endereco_consulta;
    }

    public Integer getEt_telefone_consulta() {
        return et_telefone_consulta;
    }

    public void setEt_telefone_consulta(Integer et_telefone_consulta) {
        this.et_telefone_consulta = et_telefone_consulta;
    }

    public Integer getEt_dataNasc_consulta() {
        return et_dataNasc_consulta;
    }

    public void setEt_dataNasc_consulta(Integer et_dataNasc_consulta) {
        this.et_dataNasc_consulta = et_dataNasc_consulta;
    }
}
