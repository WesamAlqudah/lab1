package miu.edu.demo.controller;

import miu.edu.demo.domain.dto.RefreshTokenRequest;
import miu.edu.demo.domain.dto.request.LoginRequest;
import miu.edu.demo.domain.dto.response.LoginResponse;
import miu.edu.demo.service.AuthService;
import miu.edu.demo.service.UaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    private final UaService uaService;


    public AuthController(AuthService authService, UaService uaService) {
        this.authService = authService;
        this.uaService = uaService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        if(loginResponse!=null){
            return ResponseEntity.ok().body(loginResponse);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/refresh")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return uaService.refreshToken(refreshTokenRequest);
    }
}