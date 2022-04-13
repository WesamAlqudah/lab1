package miu.edu.demo.service;


import miu.edu.demo.domain.Token;

public interface TokenService {

    void save(Token token);

    boolean isRefreshTokenExist(String refreshToken);

    void deleteRefreshToken(String refreshToken);

    void updateRefreshToken(String refreshToken, String newRefreshToken);
}
