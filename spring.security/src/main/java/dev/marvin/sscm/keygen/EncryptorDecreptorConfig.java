package dev.marvin.sscm.keygen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.marvin.domain.DummyUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.nio.charset.StandardCharsets;

@Configuration
public class EncryptorDecreptorConfig {

    public void standard() throws JsonProcessingException {

        String jsonData = new ObjectMapper().writeValueAsString(new DummyUser());

        String key = KeyGenerators.string().generateKey();
        BytesEncryptor bytesEncryptor = Encryptors.standard("password", key);
        byte [] encrypted = bytesEncryptor.encrypt(jsonData.getBytes(StandardCharsets.UTF_8));
        byte [] decrypted = bytesEncryptor.decrypt(encrypted);
    }
}
