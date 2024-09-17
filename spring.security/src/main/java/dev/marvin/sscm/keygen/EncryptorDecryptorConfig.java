package dev.marvin.sscm.keygen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.marvin.domain.DummyUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.nio.charset.StandardCharsets;

@Configuration
public class EncryptorDecryptorConfig {
    private static final Logger log = LoggerFactory.getLogger(EncryptorDecryptorConfig.class);

    public void standard() throws JsonProcessingException {

        String jsonData = new ObjectMapper().writeValueAsString(new DummyUser());

        String key = KeyGenerators.string().generateKey();
        BytesEncryptor bytesEncryptor = Encryptors.standard("password", key);
        byte [] encrypted = bytesEncryptor.encrypt(jsonData.getBytes(StandardCharsets.UTF_8));
        byte [] decrypted = bytesEncryptor.decrypt(encrypted);
        log.info("decrypted: {}", decrypted);
    }
}
