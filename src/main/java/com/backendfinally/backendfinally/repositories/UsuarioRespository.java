package com.backendfinally.backendfinally.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backendfinally.backendfinally.models.UsuarioModel;

@Repository
public interface UsuarioRespository extends CrudRepository<UsuarioModel, Long> {

}
