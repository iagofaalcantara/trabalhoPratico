package com.cotemig.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Atendente extends Usuario{
    public Atendente(String nome, String email, String senha, String setor, int ramal, String cargo) {
        super(nome, email, senha, setor, ramal, cargo);


    }

    public Atendente() {

        String nome;
    }


}
