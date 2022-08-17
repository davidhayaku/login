package com.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.api.models.LoginModel;
import com.api.repositories.LoginRepository;

import lombok.var;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepo;

    public Optional<LoginModel> buscaUsuario(LoginModel usuario) {
	var customers = new LoginModel();
	customers.setUsuario(usuario.getUsuario());
	customers.setPrimeiroAcesso(null);

	var matcher = ExampleMatcher.matching().withIgnoreNullValues().withMatcher("usuario",
		match -> match.endsWith().ignoreCase(true));
	var example = Example.of(customers, matcher);

	Optional<LoginModel> retorno = loginRepo.findOne(example);
	return retorno;
    }

    public Optional<LoginModel> alteraUsuario(Object object) {
	Optional<LoginModel> retorno = null;
	if (retorno.get().getPrimeiroAcesso().equals(1)) {
	    LoginModel usuario = retorno.get();
	    usuario.setPrimeiroAcesso(0);
	    loginRepo.save(usuario);
	}
	return null;

    }

    public Optional<LoginModel> findById(Integer id) {
	return null;
    }

    public Object save(Optional<LoginModel> loginModelOptional) {
	return loginRepo.save(loginModelOptional);
    }

}
