package com.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class LoginModel implements Serializable {

    public LoginModel() {
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 70)
    private String nome;

    @Column(length = 70)
    private String email;

    @Column(nullable = false, length = 70, unique = true)
    private String usuario;

    @Column(nullable = false, length = 70)
    private String senha;

    private Integer primeiroAcesso = 1;
}
