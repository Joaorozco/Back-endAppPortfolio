package com.backendfinally.backendfinally.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backendfinally.backendfinally.models.UsuarioModel;
import com.backendfinally.backendfinally.models.UsuariosRegister;

@Repository
public interface UsuarioRespository extends CrudRepository<UsuarioModel, Long> {
    
    void registrar(UsuariosRegister usuario);
    UsuariosRegister obtenerDatosPorCredenciales(UsuariosRegister usuario);
    
}
