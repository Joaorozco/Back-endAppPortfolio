package com.backendfinally.backendfinally.service;

import com.backendfinally.backendfinally.models.UsuariosRegister;

public interface UsuarioServiceImp{
    void registrar(UsuariosRegister usuario);
    UsuariosRegister obtenerDatosPorCredenciales(UsuariosRegister usuario);
}
