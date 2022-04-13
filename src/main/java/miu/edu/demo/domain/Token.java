package miu.edu.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String preRefreshToken;
    private String refToken;

    public Token(String preRefreshToken, String refToken) {
        this.preRefreshToken = preRefreshToken;
        this.refToken = refToken;
    }
}


