package com.example.loginapi.spring;

import com.example.loginapi.domain.Login;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository repository;

    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    public Login save(Login login) {
        return repository.save(login);
    }

    public Optional<Login> update(String id, Login loginDetails) {
        return repository.findById(id).map(existingLogin -> {
            existingLogin.setUsername(loginDetails.getUsername());
            existingLogin.setPassword(loginDetails.getPassword());
            existingLogin.setRoles(loginDetails.getRoles());
            return repository.save(existingLogin);
        });
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
