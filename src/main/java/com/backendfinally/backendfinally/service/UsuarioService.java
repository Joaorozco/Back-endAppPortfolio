package com.backendfinally.backendfinally.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendfinally.backendfinally.models.UsuarioModel;
import com.backendfinally.backendfinally.models.UsuariosRegister;
import com.backendfinally.backendfinally.repositories.UsuarioRespository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class UsuarioService {
    @Autowired
    UsuarioRespository usuarioRespository;
    
    @PersistenceContext
    EntityManager entityManager;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRespository.findAll();      
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRespository.save(usuario);
    }
    
    public void registrar(UsuariosRegister usuario) {
        entityManager.merge(usuario);
    }  
    
    public UsuariosRegister obtenerDatosPorCredenciales(UsuariosRegister usuario){
        String query = "FROM Usuario WHERE email = :email";
        List<UsuariosRegister> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();
        if (lista.isEmpty()){
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();        

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())){
            return lista.get(0);
        }
        return null;

    }
}