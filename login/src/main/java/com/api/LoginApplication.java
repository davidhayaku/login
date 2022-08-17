package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.controllers.LoginController;

@SpringBootApplication
public class LoginApplication {

    public static void main(String[] args) {
	LoginController loginController = new LoginController();
	SpringApplication.run(LoginApplication.class, args);
	System.out.println("Iniciando projeto...");

    }
}