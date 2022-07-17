package com.backendfinally.backendfinally.repositories;

import org.springframework.stereotype.Repository;
import com.backendfinally.backendfinally.models.UsuariosRegister;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRegisterRespository extends JpaRepository<UsuariosRegister, Long> {
}
