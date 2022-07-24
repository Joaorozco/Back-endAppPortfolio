package com.backendfinally.backendfinally.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuario_register")
@ToString @EqualsAndHashCode
public class UsuariosRegister implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "id", unique = true, nullable = false)
    private Long id;  
    
    @Getter @Setter @Column(name = "username")
    private String username;  
    
    @Getter @Setter @Column(name = "useremail")
    public String useremail;
    
    @Getter @Setter @Column(name = "password")
    public String password;

    //Constructor

    public UsuariosRegister() {
    }

    public UsuariosRegister(Long id, String username, String useremail, String password) {
        this.id = id;
        this.username = username;
        this.username = useremail;
        this.password = password;
    }    

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
