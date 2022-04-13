package miu.edu.demo.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.demo.domain.Token;
import miu.edu.demo.domain.dto.RefreshTokenRequest;
import miu.edu.demo.domain.dto.request.LoginRequest;
import miu.edu.demo.domain.dto.response.LoginResponse;
import miu.edu.demo.exception.InvalidUserException;
import miu.edu.demo.service.TokenService;
import miu.edu.demo.service.UaService;
import miu.edu.demo.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaServiceImpl implements UaService {

  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;
  private final JwtUtil jwtUtil;
  private final TokenService tokenService;

  @Override
  public LoginResponse login(LoginRequest loginRequest) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginRequest.getEmail(), loginRequest.getPassword()));
    } catch (BadCredentialsException e) {
      log.info("Bad Credentials");
      throw new InvalidUserException("Invalid credentials.");
    }
    final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

    final String accessToken = jwtUtil.generateToken(userDetails);
    //    final String accessToken = jwtTokenUtil.generateToken(userDetails);
    final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
    Token token = new Token(refreshToken, refreshToken);
    token.setRefToken(refreshToken);
    tokenService.save(token);
    return new LoginResponse(accessToken, refreshToken);
  }

  @Override
  public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
    boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
    if (isRefreshTokenValid) {
      boolean isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
      isAccessTokenExpired = true;
      if (isAccessTokenExpired) {
        // if refreshToken doesn't exist in DB,
        // then the passed token should be the previous_refreshToken
        if (!tokenService.isRefreshTokenExist(refreshTokenRequest.getRefreshToken())) {
          // deleting token object based on previous_refreshToken
          // after this step, re-login is required
          tokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
          throw new InvalidUserException("Invalid Refresh Token");
        }
        // generate new refresh token and update it into token table
        String newRefreshToken =
                jwtUtil.generateNewRefreshToken(refreshTokenRequest.getAccessToken());
        tokenService.updateRefreshToken(refreshTokenRequest.getRefreshToken(), newRefreshToken);

        System.out.println("ACCESS TOKEN IS EXPIRED");
        final String newAccessToken =
                jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
        new LoginResponse(newAccessToken, newRefreshToken);
      } else {
        System.out.println("ACCESS TOKEN IS NOT EXPIRED");
      }
    }
    return new LoginResponse(
            refreshTokenRequest.getAccessToken(), refreshTokenRequest.getRefreshToken());
  }
}

