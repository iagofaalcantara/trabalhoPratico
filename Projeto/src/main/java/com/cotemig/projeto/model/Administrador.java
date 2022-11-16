package com.cotemig.projeto.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "administrador")
public class Administrador extends Usuario{
    public Administrador() {
    }

    public Administrador(String nome, String email, String senha, String setor, int ramal, String cargo) {
        super(nome, email, senha, setor, ramal, cargo);
    }

}
