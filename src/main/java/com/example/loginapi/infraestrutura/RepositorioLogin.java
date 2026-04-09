package com.example.loginapi.infraestrutura;

import com.example.loginapi.dominio.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLogin extends MongoRepository<Login, String> {
}
