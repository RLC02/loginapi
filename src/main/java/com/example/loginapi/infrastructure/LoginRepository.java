package com.example.loginapi.infrastructure;

import com.example.loginapi.core.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<Login, String> {
}
