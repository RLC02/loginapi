package com.example.loginapi.casosdeuso;

import com.example.loginapi.dominio.Login;
import com.example.loginapi.infraestrutura.RepositorioLogin;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoLogin {

    private final RepositorioLogin repositorio;

    public ServicoLogin(RepositorioLogin repositorio) {
        this.repositorio = repositorio;
    }

    public Login salvar(Login login) {
        return repositorio.save(login);
    }

    public Optional<Login> atualizar(String id, Login detalhesLogin) {
        return repositorio.findById(id).map(loginExistente -> {
            loginExistente.setUsername(detalhesLogin.getUsername());
            loginExistente.setPassword(detalhesLogin.getPassword());
            loginExistente.setRoles(detalhesLogin.getRoles());
            return repositorio.save(loginExistente);
        });
    }

    public void deletar(String id) {
        repositorio.deleteById(id);
    }
}
