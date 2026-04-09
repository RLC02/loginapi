package com.example.loginapi.infrastructure;

import com.example.loginapi.application.LoginService;
import com.example.loginapi.core.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Login> createLogin(@RequestBody Login login) {
        return ResponseEntity.ok(loginService.save(login));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable String id, @RequestBody Login login) {
        return loginService.update(id, login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable String id) {
        loginService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<String> getLogin() {
        return ResponseEntity.ok("Realizar Login");
    }
}
