package com.cotemig.projeto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipo;

    public Perfil( String tipo) {

        this.tipo = tipo;
    }

    public Perfil(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
