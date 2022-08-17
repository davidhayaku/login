package com.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.LoginModel;
import com.api.services.LoginService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/web")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    @Autowired
    private LoginService loginServ;

//    @GetMapping(value = "/teste")
//    public String index() {
//	return "Olá Mundo Spring Boot";
//    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> postOneLogin(@RequestBody String json) {
	Gson gson = new Gson();
	LoginModel usuario = gson.fromJson(json, LoginModel.class);
	Optional<LoginModel> loginModelOptional = loginServ.buscaUsuario(usuario);
	if (!loginModelOptional.isPresent()) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este usuário não existe!!!");
	} else if (!loginModelOptional.get().getSenha().equals(usuario.getSenha())) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Senha está incorreta!!!");
	} else {
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body(gson.toJson(loginModelOptional));
	}
    }

    @PutMapping(value = "/altera")
    public ResponseEntity<String> alteraAcesso(@RequestBody String json) {
	Gson gson = new Gson();
	LoginModel usuario = gson.fromJson(json, LoginModel.class);
	Optional<LoginModel> loginModelOptional = loginServ.alteraUsuario(usuario);
	if (!loginModelOptional.isPresent()) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este usuário não existe!!!");
	} else {
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body(gson.toJson(loginModelOptional));
	}
    }
}
