package miu.edu.demo.repo;


import miu.edu.demo.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<Token, Long> {
  boolean existsByRefreshToken(String refreshToken);

  void deleteByPreviousRefreshToken(String refreshToken);

  Token findByRefreshToken(String refreshToken);

  Token findByPreviousRefreshToken(String refreshToken);
}
