package com.cotemig.projeto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String setor;
    private int ramal;
    private String cargo;

    //construtor criado pela ide, se excluir da erro
    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String setor, int ramal, String cargo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
        this.ramal = ramal;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
