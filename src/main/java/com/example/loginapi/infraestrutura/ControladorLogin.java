package com.example.loginapi.infraestrutura;

import com.example.loginapi.casosdeuso.ServicoLogin;
import com.example.loginapi.dominio.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class ControladorLogin {

    private final ServicoLogin servicoLogin;

    public ControladorLogin(ServicoLogin servicoLogin) {
        this.servicoLogin = servicoLogin;
    }

    @PostMapping
    public ResponseEntity<Login> criarLogin(@RequestBody Login login) {
        return ResponseEntity.ok(servicoLogin.salvar(login));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Login> atualizarLogin(@PathVariable String id, @RequestBody Login login) {
        return servicoLogin.atualizar(id, login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLogin(@PathVariable String id) {
        servicoLogin.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<String> getLogin() {
        return ResponseEntity.ok("Realizar Login");
    }
}
