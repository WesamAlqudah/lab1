package miu.edu.demo.service;


import miu.edu.demo.domain.dto.RefreshTokenRequest;
import miu.edu.demo.domain.dto.request.LoginRequest;
import miu.edu.demo.domain.dto.response.LoginResponse;

public interface UaService {
  LoginResponse login(LoginRequest loginRequest);

  LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
