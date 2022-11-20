package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Perfil;

import java.util.List;

public interface PerfilService {
    void savePerfil(Perfil perfi);

    void deletePerfil(Perfil perfil);

    public List<Perfil> getAllPerfis();
}
