package com.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.models.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
    public Object save(Optional<LoginModel> loginModelOptional);

}
