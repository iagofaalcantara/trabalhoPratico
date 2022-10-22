package com.cotemig.projeto.model;

import java.util.Date;

public class Chamado {
    private String tipo;
    private String descricao;
    private Date data;
    private String[] anexo;
    private String status;
    private int nivelPrioridade;
    public Chamado(String tipo, String descricao, Date data, String[] anexo, String status, int nivelPrioridade) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.anexo = anexo;
        this.status = status;
        this.nivelPrioridade = nivelPrioridade;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String[] getAnexo() {
        return anexo;
    }

    public void setAnexo(String[] anexo) {
        this.anexo = anexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }
}
