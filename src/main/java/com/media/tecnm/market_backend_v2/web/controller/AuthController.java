package com.media.tecnm.market_backend_v2.web.controller;

import com.media.tecnm.market_backend_v2.domain.Client;
import com.media.tecnm.market_backend_v2.domain.service.ClientService;
import com.media.tecnm.market_backend_v2.web.dto.AuthResponse;
import com.media.tecnm.market_backend_v2.web.dto.LoginRequest;
import com.media.tecnm.market_backend_v2.web.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Authentication with JWT")
public class AuthController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @Operation(summary = "Login with client ID and password",
            description = "Validates the credentials against the BCrypt password stored in the database and returns a JWT access token")
    @ApiResponse(responseCode = "200",
            description = "Login successful, JWT token returned")
    @ApiResponse(responseCode = "401",
            description = "Invalid credentials")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        Optional<Client> client = clientService.getClient(request.getClientId());
        if (client.isEmpty()
                || client.get().getPassword() == null
                || request.getPassword() == null
                || !passwordEncoder.matches(request.getPassword(), client.get().getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtil.generateToken(request.getClientId());
        return ResponseEntity.ok(new AuthResponse(token, request.getClientId()));
    }
}
