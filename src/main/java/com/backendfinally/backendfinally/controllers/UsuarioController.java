package com.backendfinally.backendfinally.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendfinally.backendfinally.models.UsuarioModel;
import com.backendfinally.backendfinally.models.UsuariosRegister;
import com.backendfinally.backendfinally.service.UsuarioService;
import com.backendfinally.backendfinally.service.UsuarioServiceImp;
import com.backendfinally.backendfinally.utils.JWTUtils;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController

public class UsuarioController implements UsuarioServiceImp{
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private JWTUtils jwtUtil;
    
    
    @RequestMapping(value = "api/usuario", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    @RequestMapping(value = "api/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    @CrossOrigin(origins = "http://localhost:4200")
    public void registrar(@RequestBody UsuariosRegister usuario) {
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioService.registrar(usuario);
    }

    @RequestMapping(value = "api/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UsuariosRegister usuario) {
        UsuariosRegister usuarioLogueado = usuarioService.obtenerDatosPorCredenciales(usuario);
        if(usuarioLogueado != null){
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail()); 
            return tokenJwt;
        }
        return "FAIL";
    }

    @Override
    public UsuariosRegister obtenerDatosPorCredenciales(UsuariosRegister usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
