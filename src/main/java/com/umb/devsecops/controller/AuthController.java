package com.umb.devsecops.controller;

import com.umb.devsecops.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final JwtTokenProvider tokenProvider;

    public AuthController(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        if ("admin".equals(username) && "admin123".equals(password)) {
            String token = tokenProvider.generateToken(username, "ROLE_ADMIN");
            return ResponseEntity.ok(Map.of("token", token, "role", "ROLE_ADMIN"));
        } else if ("user".equals(username) && "user123".equals(password)) {
            String token = tokenProvider.generateToken(username, "ROLE_USER");
            return ResponseEntity.ok(Map.of("token", token, "role", "ROLE_USER"));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
    }

    @GetMapping("/user/profile")
    public ResponseEntity<?> getUserProfile() {
        return ResponseEntity.ok(Map.of("status", "Acceso concedido a recurso de usuario"));
    }

    @GetMapping("/admin/dashboard")
    public ResponseEntity<?> getAdminDashboard() {
        return ResponseEntity.ok(Map.of("status", "Acceso concedido a panel administrativo"));
    }
}
