package com.cotemig.projeto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "atendente")
public class Atendente extends Usuario{
    public Atendente(String nome, String email, String senha, String setor, int ramal, String cargo) {
        super(nome, email, senha, setor, ramal, cargo);


    }

    public Atendente() {

        String nome;
    }


}
