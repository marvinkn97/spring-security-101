package dev.marvin.sscm.keygen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

@Configuration
public class KeyConfig {

    private static final Logger logger = LoggerFactory.getLogger(KeyConfig.class);

    public String stringKeygen(){
        StringKeyGenerator stringKeyGenerator = KeyGenerators.string();
        return stringKeyGenerator.generateKey();
    }

    public byte[] byteKeygen(){
        logger.info("byteKeygen bean called");
        BytesKeyGenerator bytesKeyGenerator = KeyGenerators.secureRandom();
        byte[] key = bytesKeyGenerator.generateKey();
        int keyLength = bytesKeyGenerator.getKeyLength();
        logger.info("keyLength: {}", keyLength);
        return key;
    }

}
