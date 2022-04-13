package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Token;
import miu.edu.demo.repo.TokenRepo;
import miu.edu.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

  private TokenRepo tokenRepository;

  @Autowired
  public void setTokenRepository(TokenRepo tokenRepository) {
    this.tokenRepository = tokenRepository;
  }

  @Override
  public void save(Token token) {
    tokenRepository.save(token);
  }

  @Override
  public boolean isRefreshTokenExist(String refreshToken) {
    return tokenRepository.existsByRefreshToken(refreshToken);
  }

  @Override
  public void deleteRefreshToken(String refreshToken) {
    Token token = tokenRepository.findByPreviousRefreshToken(refreshToken);
    if (token != null) {
      tokenRepository.delete(token);
    }
  }

  @Override
  public void updateRefreshToken(String refreshToken, String newRefreshToken) {
    Token token = tokenRepository.findByRefreshToken(refreshToken);
    token.setPreRefreshToken(token.getRefToken());
    token.setRefToken(newRefreshToken);
    tokenRepository.save(token);
  }
}
