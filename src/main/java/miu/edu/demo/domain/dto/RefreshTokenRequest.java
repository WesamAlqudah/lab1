package miu.edu.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RefreshTokenRequest {
  private String accessToken;
  private String refreshToken;
}
