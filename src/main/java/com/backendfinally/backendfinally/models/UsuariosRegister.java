package com.backendfinally.backendfinally.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_register")
public class UsuariosRegister {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( unique = true, nullable = false)
    private Long id;  
    private String username;  
    private String useremail;
    private String password;

    //Constructor

    public UsuariosRegister() {
    }

    public UsuariosRegister(Long id, String nombreCompleto, String email, String password) {
        this.id = id;
        this.username = nombreCompleto;
        this.username = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return username;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.username = nombreCompleto;
    }

    public String getEmail() {
        return useremail;
    }

    public void setEmail(String email) {
        this.useremail = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
