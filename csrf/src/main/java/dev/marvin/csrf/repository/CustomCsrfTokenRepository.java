package dev.marvin.csrf.repository;

import dev.marvin.csrf.domain.Token;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomCsrfTokenRepository implements CsrfTokenRepository {
    private final TokenRepository tokenRepository;

    public CustomCsrfTokenRepository(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X_CSRF_TOKEN", "_csrf", uuid);
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest request, HttpServletResponse response) {
        String clientId = request.getHeader("X_ID");
        Optional<Token> existingToken = tokenRepository.findByClientId(clientId);
        Token token;
        if (existingToken.isPresent()) {
            token = existingToken.get();
            token.setToken(csrfToken.getToken());
        } else {
            token = new Token();
            token.setToken(csrfToken.getToken());
            token.setClientId(clientId);
        }
        tokenRepository.save(token);

    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        String clientId = request.getHeader("X_ID");
        Optional<Token> existingToken = tokenRepository.findByClientId(clientId);
        if (existingToken.isPresent()) {
           Token token = existingToken.get();
           return new DefaultCsrfToken("X_CSRF_TOKEN", "_csrf", token.getToken());
        }
        return null;
    }
}
